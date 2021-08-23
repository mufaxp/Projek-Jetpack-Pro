package com.labhidrogen.labmovies.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.labhidrogen.labmovies.data.source.remote.StatusResponse
import com.labhidrogen.labmovies.data.source.remote.response.ApiResponse
import com.labhidrogen.labmovies.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class NetworkBoundResource<ResultType, RequestType> {
    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDB()

        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData ->
                    result.value = Resource.success(newData)
                }
            }
        }

    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()
        result.addSource(dbSource) { newData ->
            result.value = Resource.loading(newData)
        }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when (response.status) {
                StatusResponse.SUCCESS -> GlobalScope.launch(Dispatchers.IO) {
                    saveCallResult(response.body)
                    withContext(Dispatchers.Main) {
                        result.addSource(loadFromDB()) { newData ->
                            result.value = Resource.success(newData)
                        }
                    }
                }
                StatusResponse.EMPTY -> GlobalScope.launch {
                    result.addSource(loadFromDB()) { newData ->
                        result.value = Resource.success(newData)
                    }
                }
                StatusResponse.ERROR -> {
                    onFetchFailed()
                    result.addSource(dbSource) { newData ->
                        result.value = Resource.error(response.message, newData)
                    }
                }
            }
        }
    }

    abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    abstract fun saveCallResult(data: RequestType)

    abstract fun shouldFetch(data: ResultType?): Boolean

    abstract fun loadFromDB(): LiveData<ResultType>

    private fun onFetchFailed() {}

    fun asLiveData(): LiveData<Resource<ResultType>> = result
}