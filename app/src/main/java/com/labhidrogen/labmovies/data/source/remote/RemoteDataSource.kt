package com.labhidrogen.labmovies.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.labhidrogen.labmovies.data.source.remote.response.ApiResponse
import com.labhidrogen.labmovies.data.source.remote.response.ProgrammeResponse
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity
import com.labhidrogen.labmovies.utils.EspressoIdlingResource
import com.labhidrogen.labmovies.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    fun getListMovie(): LiveData<ApiResponse<List<ProgrammeResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<ProgrammeResponse>>>()
        resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
        EspressoIdlingResource.decrement()
        return resultMovie
    }

    fun getListTvShow(): LiveData<ApiResponse<List<ProgrammeResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<ProgrammeResponse>>>()
        resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShows())
        EspressoIdlingResource.decrement()
        return resultTvShow
    }

    fun getDetailProgramme(type: Int, programmeId: String): LiveData<ApiResponse<ProgrammeResponse>> {
        EspressoIdlingResource.increment()
        val programmeResult = MutableLiveData<ApiResponse<ProgrammeResponse>>()
        val programmeResponse = if (type == DetailProgrammeActivity.MOVIES_TYPE) {
            ApiResponse.success(jsonHelper.loadMovies())
        } else {
            ApiResponse.success(jsonHelper.loadTvShows())
        }
        lateinit var programme: ProgrammeResponse
        for (response in programmeResponse.body) {
            if (response.programmeId == programmeId) {
                programme = ProgrammeResponse(
                    response.programmeId,
                    response.title,
                    response.description,
                    response.yearRelease,
                    response.releaseDate,
                    response.numberOfEpisode,
                    response.ageRating,
                    response.duration,
                    response.genre,
                    response.director,
                    response.writer,
                    response.stars,
                    response.rating,
                    response.language,
                    response.imagePath,
                )
            }
        }
        programmeResult.postValue(ApiResponse.success(programme))
        EspressoIdlingResource.decrement()
        return programmeResult
    }

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }
}