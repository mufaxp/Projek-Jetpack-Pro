package com.labhidrogen.labmovies.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import com.labhidrogen.labmovies.data.NetworkBoundResource
import com.labhidrogen.labmovies.data.source.local.LocalDataSource
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.data.source.remote.RemoteDataSource
import com.labhidrogen.labmovies.data.source.remote.response.ApiResponse
import com.labhidrogen.labmovies.data.source.remote.response.ProgrammeResponse
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity.Companion.MOVIES_TYPE
import com.labhidrogen.labmovies.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProgrammeRepositoryForTest(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :
    ProgrammeDataSource {

    override fun getListMovie(): LiveData<Resource<List<ProgrammeEntity>>> {
        return object : NetworkBoundResource<List<ProgrammeEntity>, List<ProgrammeResponse>>() {
            override fun createCall(): LiveData<ApiResponse<List<ProgrammeResponse>>> =
                remoteDataSource.getListMovie()

            override fun saveCallResult(data: List<ProgrammeResponse>) {
                val movieList = ArrayList<ProgrammeEntity>()
                for (response in data) {
                    val movie = ProgrammeEntity(
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
                        response.imagePath
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }

            override fun shouldFetch(data: List<ProgrammeEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDB(): LiveData<List<ProgrammeEntity>> =
                localDataSource.getAllMovies()

        }.asLiveData()
    }

    override fun getListTvShow(): LiveData<Resource<List<ProgrammeEntity>>> {
        return object : NetworkBoundResource<List<ProgrammeEntity>, List<ProgrammeResponse>>() {
            override fun createCall(): LiveData<ApiResponse<List<ProgrammeResponse>>> =
                remoteDataSource.getListTvShow()

            override fun saveCallResult(data: List<ProgrammeResponse>) {
                val tvShowList = ArrayList<ProgrammeEntity>()
                for (response in data) {
                    val movie = ProgrammeEntity(
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
                        response.imagePath
                    )
                    tvShowList.add(movie)
                }
                localDataSource.insertTvShows(tvShowList)
            }

            override fun shouldFetch(data: List<ProgrammeEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDB(): LiveData<List<ProgrammeEntity>> =
                localDataSource.getAllTvShows()
        }.asLiveData()
    }

    override fun getBookmarkedMovies(): LiveData<List<ProgrammeEntity>> =
        localDataSource.getBookmarkedMovies()

    override fun getBookmarkedTvShows(): LiveData<List<ProgrammeEntity>> =
        localDataSource.getBookmarkedTvShows()

    override fun setMovieBookmark(movie: ProgrammeEntity, state: Boolean) {
        GlobalScope.launch(Dispatchers.IO) {
            localDataSource.setMovieBookmark(movie, state)
        }
    }

    override fun setTvShowBookmark(tvShow: ProgrammeEntity, state: Boolean) {
        GlobalScope.launch(Dispatchers.IO) {
            localDataSource.setTvShowBookmark(tvShow, state)
        }
    }

    override fun getProgrammeDetail(programmeId: String, type: Int): LiveData<ProgrammeEntity> {
        return if (type == MOVIES_TYPE) {
            localDataSource.getMovie(programmeId)
        } else {
            localDataSource.getTvShow(programmeId)
        }
    }
}