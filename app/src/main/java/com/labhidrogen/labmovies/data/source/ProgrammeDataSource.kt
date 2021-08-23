package com.labhidrogen.labmovies.data.source

import androidx.lifecycle.LiveData
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.vo.Resource

interface ProgrammeDataSource {
    fun getListMovie(): LiveData<Resource<List<ProgrammeEntity>>>

    fun getListTvShow(): LiveData<Resource<List<ProgrammeEntity>>>

    fun getBookmarkedMovies(): LiveData<List<ProgrammeEntity>>

    fun getBookmarkedTvShows(): LiveData<List<ProgrammeEntity>>

    fun setMovieBookmark(movie: ProgrammeEntity, state: Boolean)

    fun setTvShowBookmark(tvShow: ProgrammeEntity, state: Boolean)

    fun getProgrammeDetail(programmeId: String, type: Int): LiveData<ProgrammeEntity>
}