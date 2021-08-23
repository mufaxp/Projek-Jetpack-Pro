package com.labhidrogen.labmovies.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity

@Dao
interface TvShowsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(movies: List<ProgrammeEntity>)

    @Query("select * from programmeentity")
    fun getTvShows(): LiveData<List<ProgrammeEntity>>

    @Query("select * from programmeentity where bookmarked = 1")
    fun getBookmarkedTvShow(): LiveData<List<ProgrammeEntity>>

    @Query("select * from programmeentity where programmeId =:programmeId")
    fun getDetailTvShow(programmeId: String): LiveData<ProgrammeEntity>

    @Update
    fun updateTvShow(tvShow: ProgrammeEntity)
}