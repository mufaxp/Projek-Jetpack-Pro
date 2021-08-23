package com.labhidrogen.labmovies.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity

@Database(entities = [ProgrammeEntity::class], version = 1, exportSchema = false)
abstract class TvShowDatabase : RoomDatabase(){
    abstract fun tvShowDao(): TvShowsDao

    companion object {
        @Volatile
        private var instance: TvShowDatabase? = null

        fun getInstance(context: Context): TvShowDatabase =
            instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    TvShowDatabase::class.java,
                    "TvShow.db"
                ).build().apply { instance = this }
            }
    }
}