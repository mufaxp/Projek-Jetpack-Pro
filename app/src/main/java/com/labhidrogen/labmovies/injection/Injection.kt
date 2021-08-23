package com.labhidrogen.labmovies.injection

import android.content.Context
import com.labhidrogen.labmovies.data.source.ProgrammeRepository
import com.labhidrogen.labmovies.data.source.local.LocalDataSource
import com.labhidrogen.labmovies.data.source.local.room.MovieDatabase
import com.labhidrogen.labmovies.data.source.local.room.TvShowDatabase
import com.labhidrogen.labmovies.data.source.remote.RemoteDataSource
import com.labhidrogen.labmovies.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): ProgrammeRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        val movieDatabase = MovieDatabase.getInstance(context)

        val tvShowDatabase = TvShowDatabase.getInstance(context)

        val localDataSource =
            LocalDataSource.getInstance(movieDatabase.movieDao(), tvShowDatabase.tvShowDao())

        return ProgrammeRepository.getInstance(remoteDataSource, localDataSource)
    }
}