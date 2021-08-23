package com.labhidrogen.labmovies.utils

import android.content.Context
import com.labhidrogen.labmovies.data.source.remote.response.ProgrammeResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val inputStream = context.assets.open(fileName)
            val buffer = ByteArray(inputStream.available())
            inputStream.read(buffer)
            inputStream.close()
            String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<ProgrammeResponse> {
        val list = ArrayList<ProgrammeResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)
                val programmeId = movie.getString("id")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val yearRelease = movie.getString("releaseYear")
                val releaseDate = movie.getString("releaseDate")
                val numberOfEpisode = movie.getString("numberOfEpisode")
                val ageRating = movie.getString("ageRating")
                val duration = movie.getString("duration")
                val genre = movie.getString("genre")
                val director = movie.getString("director")
                val writer = movie.getString("writer")
                val stars = movie.getString("stars")
                val rating = movie.getString("rating")
                val language = movie.getString("language")
                val imagePath = movie.getString("imagePath")

                val movieResponse = ProgrammeResponse(
                    programmeId, title, description, yearRelease, releaseDate, numberOfEpisode,
                    ageRating, duration, genre, director, writer, stars, rating, language, imagePath
                )
                list.add(movieResponse)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShows(): List<ProgrammeResponse> {
        val list = ArrayList<ProgrammeResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponses.json").toString())
            val listArray = responseObject.getJSONArray("shows")
            for (i in 0 until listArray.length()) {
                val tvShows = listArray.getJSONObject(i)
                val programmeId = tvShows.getString("id")
                val title = tvShows.getString("title")
                val description = tvShows.getString("description")
                val yearRelease = tvShows.getString("releaseYear")
                val releaseDate = tvShows.getString("releaseDate")
                val numberOfEpisode = tvShows.getString("numberOfEpisode")
                val ageRating = tvShows.getString("ageRating")
                val duration = tvShows.getString("duration")
                val genre = tvShows.getString("genre")
                val director = tvShows.getString("director")
                val writer = tvShows.getString("writer")
                val stars = tvShows.getString("stars")
                val rating = tvShows.getString("rating")
                val language = tvShows.getString("language")
                val imagePath = tvShows.getString("imagePath")

                val tvShowResponse = ProgrammeResponse(
                    programmeId, title, description, yearRelease, releaseDate, numberOfEpisode,
                    ageRating, duration, genre, director, writer, stars, rating, language, imagePath
                )
                list.add(tvShowResponse)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}