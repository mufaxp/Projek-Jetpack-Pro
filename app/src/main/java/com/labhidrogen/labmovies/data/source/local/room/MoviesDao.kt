package com.labhidrogen.labmovies.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movies: List<ProgrammeEntity>)

    @Query("select * from programmeentity")
    fun getMovies(): LiveData<List<ProgrammeEntity>>

    @Query("select * from programmeentity where bookmarked = 1")
    fun getBookmarkedMovie(): LiveData<List<ProgrammeEntity>>

    @Query("select * from programmeentity where programmeId =:programmeId")
    fun getDetailMovie(programmeId: String): LiveData<ProgrammeEntity>

    @Update
    fun updateMovie(movie: ProgrammeEntity)
}