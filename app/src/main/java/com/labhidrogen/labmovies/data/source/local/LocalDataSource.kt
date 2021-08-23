package com.labhidrogen.labmovies.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.liveData
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.data.source.local.room.MoviesDao
import com.labhidrogen.labmovies.data.source.local.room.TvShowsDao

class LocalDataSource private constructor(
    private val moviesDao: MoviesDao,
    private val tvShowsDao: TvShowsDao
) {

    fun getAllMovies(): LiveData<List<ProgrammeEntity>> = moviesDao.getMovies()

    fun getAllTvShows(): LiveData<List<ProgrammeEntity>> = tvShowsDao.getTvShows()

    fun getBookmarkedMovies(): LiveData<List<ProgrammeEntity>> = moviesDao.getBookmarkedMovie()

    fun getBookmarkedTvShows(): LiveData<List<ProgrammeEntity>> = tvShowsDao.getBookmarkedTvShow()

    fun insertMovies(movies: List<ProgrammeEntity>) = moviesDao.insertMovie(movies)

    fun insertTvShows(tvShows: List<ProgrammeEntity>) = tvShowsDao.insertTvShows(tvShows)

    fun getMovie(programmeId: String): LiveData<ProgrammeEntity> = moviesDao.getDetailMovie(programmeId)

    fun getTvShow(programmeId: String): LiveData<ProgrammeEntity> = tvShowsDao.getDetailTvShow(programmeId)

    fun setMovieBookmark(movie: ProgrammeEntity, newState: Boolean) {
        movie.bookmarked = newState
        moviesDao.updateMovie(movie)
    }

    fun setTvShowBookmark(tvShow: ProgrammeEntity, newState: Boolean) {
        tvShow.bookmarked = newState
        tvShowsDao.updateTvShow(tvShow)
    }

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(moviesDao: MoviesDao, tvShowsDao: TvShowsDao): LocalDataSource =
            instance ?: LocalDataSource(moviesDao, tvShowsDao)
    }
}