package com.labhidrogen.labmovies.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class ProgrammeEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "programmeId")
    var programmeId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "yearRelease")
    var yearRelease: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "numberOfEpisode")
    var numberOfEpisode: String,

    @ColumnInfo(name = "ageRating")
    var ageRating: String,

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "director")
    var director: String,

    @ColumnInfo(name = "writer")
    var writer: String,

    @ColumnInfo(name = "stars")
    var stars: String,

    @ColumnInfo(name = "rating")
    var rating: String,

    @ColumnInfo(name = "language")
    var language: String,

    @ColumnInfo(name = "imagePath")
    var imagePath: String,

    @ColumnInfo(name = "bookmarked")
    var bookmarked: Boolean = false
) : Parcelable
