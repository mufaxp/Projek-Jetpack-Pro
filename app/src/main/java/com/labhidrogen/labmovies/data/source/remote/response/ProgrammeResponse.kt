package com.labhidrogen.labmovies.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProgrammeResponse(
    var programmeId: String,
    var title: String,
    var description: String,
    var yearRelease: String,
    var releaseDate: String,
    var numberOfEpisode: String,
    var ageRating: String,
    var duration: String,
    var genre: String,
    var director: String,
    var writer: String,
    var stars: String,
    var rating: String,
    var language: String,
    var imagePath: String
) : Parcelable
