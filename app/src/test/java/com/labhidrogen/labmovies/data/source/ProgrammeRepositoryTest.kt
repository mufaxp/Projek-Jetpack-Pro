package com.labhidrogen.labmovies.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.labhidrogen.labmovies.data.source.local.LocalDataSource
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.data.source.remote.RemoteDataSource
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity
import com.labhidrogen.labmovies.utils.Data
import com.labhidrogen.labmovies.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class ProgrammeRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val programmeRepository = ProgrammeRepositoryForTest(remote, local)

    private val movieResponses = Data.generateRemoteDummyMovies()
    private val moviesId = movieResponses[0].programmeId
    private val tvShowResponses = Data.generateRemoteDummyTvShows()
    private val tvShowId = tvShowResponses[0].programmeId
    private val dummyMovie = movieResponses[0]
    private val dummyTvShow = tvShowResponses[0]

    /*
    * getListMovie()
    * 1. Memanipulasi data movies ketika pemanggilan data di kelas LocalDataSource
    * 2. Memastikan metode di kelas LocalDataSource terpanggil
    * 3. Memastikan data tidak null
    * 4. Melakukan pengecekan kesesuaian jumlah data movies
    */
    @Test
    fun getListMovie() {
        val dummyMovies = MutableLiveData<List<ProgrammeEntity>>()
        dummyMovies.value = Data.generateDataMovies()
        `when`(local.getAllMovies()).thenReturn(dummyMovies)

        val entities = LiveDataTestUtil.getValue(programmeRepository.getListMovie())
        verify(local).getAllMovies()
        assertNotNull(entities)
        assertEquals(movieResponses.size, entities.data?.size)
    }

    /*
    * getListTvShow()
    * 1. Memanipulasi data tvShows ketika pemanggilan data di kelas LocalDataSource
    * 2. Memastikan metode di kelas LocalDataSource terpanggil
    * 3. Memastikan data tidak null
    * 4. Melakukan pengecekan kesesuaian jumlah data tvShows
    */
    @Test
    fun getListTvShow() {
        val dummyTvShows = MutableLiveData<List<ProgrammeEntity>>()
        dummyTvShows.value = Data.generateDataTvShow()
        `when`(local.getAllTvShows()).thenReturn(dummyTvShows)

        val entities = LiveDataTestUtil.getValue(programmeRepository.getListTvShow())
        verify(local).getAllTvShows()
        assertNotNull(entities)
        assertEquals(tvShowResponses.size, entities.data?.size)
    }

    /* getBookmarkedMovies()
    * 1. Memanipuasi data bookmarkedMovies ketika pemanggilan data di kelas LocalDataSource
    * 2. Memastikan metode di kelas LocalDataSource terpanggil
    * 3. Memastikan data tidak null
    * 4. Melakukan pengecekan kesesuaian jumlah data bookmarkedMovies
    */
    @Test
    fun getBookmarkedMovies() {
        val dummyBookmarkedMovies = MutableLiveData<List<ProgrammeEntity>>()
        dummyBookmarkedMovies.value = Data.generateBookmarkedMovies()
        `when`(local.getBookmarkedMovies()).thenReturn(dummyBookmarkedMovies)

        val movieEntities = LiveDataTestUtil.getValue(programmeRepository.getBookmarkedMovies())
        verify(local).getBookmarkedMovies()
        assertNotNull(movieEntities)
        assertEquals(Data.generateBookmarkedMovies().size, movieEntities.size)
    }

    /* getBookmarkedTvShows()
    * 1. Memanipuasi data bookmarkedTvShows ketika pemanggilan data di kelas LocalDataSource
    * 2. Memastikan metode di kelas LocalDataSource terpanggil
    * 3. Memastikan data tidak null
    * 4. Melakukan pengecekan kesesuaian jumlah data bookmarkedTvShows
    */
    @Test
    fun getBookmarkedTvShows() {
        val dummyBookmarkedTvShows = MutableLiveData<List<ProgrammeEntity>>()
        dummyBookmarkedTvShows.value = Data.generateBookmarkedTvShows()
        `when`(local.getBookmarkedTvShows()).thenReturn(dummyBookmarkedTvShows)

        val tvShowEntities = LiveDataTestUtil.getValue(programmeRepository.getBookmarkedTvShows())
        verify(local).getBookmarkedTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(Data.generateBookmarkedTvShows().size, tvShowEntities.size)
    }

    @Test
    fun setMovieBookmark() {

    }

    @Test
    fun setTvShowBookmark() {

    }

    /*
    * getMovieDetail()
    * 1. Memanipulasi data ketika pemanggilan data di kelas LocalDataSource
    * 2. Memastikan metode di kelas LocalDataSource terpanggil
    * 3. Memastikan data tidak null
    * 4. Membandingkan kesesuaian data dengan yang diharapkan
    */
    @Test
    fun getMovieDetail() {
        val dummyMovieEntity = MutableLiveData<ProgrammeEntity>()
        dummyMovieEntity.value = Data.generateDataMovies()[0]
        `when`(local.getMovie(moviesId)).thenReturn(dummyMovieEntity)

        val movie = LiveDataTestUtil.getValue(
            programmeRepository.getProgrammeDetail(
                moviesId,
                DetailProgrammeActivity.MOVIES_TYPE
            )
        )
        verify(local).getMovie(moviesId)
        assertNotNull(movie)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.description, movie.description)
        assertEquals(dummyMovie.yearRelease, movie.yearRelease)
        assertEquals(dummyMovie.releaseDate, movie.releaseDate)
        assertEquals(dummyMovie.numberOfEpisode, movie.numberOfEpisode)
        assertEquals(dummyMovie.ageRating, movie.ageRating)
        assertEquals(dummyMovie.duration, movie.duration)
        assertEquals(dummyMovie.genre, movie.genre)
        assertEquals(dummyMovie.director, movie.director)
        assertEquals(dummyMovie.writer, movie.writer)
        assertEquals(dummyMovie.stars, movie.stars)
        assertEquals(dummyMovie.rating, movie.rating)
        assertEquals(dummyMovie.language, movie.language)
    }

    /*
    * getTvShowDetail
    * 1. Memanipulasi data ketika pemanggilan data di kelas LocalDataSource
    * 2. Memastikan metode di kelas LocalDataSource terpanggil
    * 3. Memastikan data tidak null
    * 4. Membandingkan kesesuaian data dengan yang diharapkan
    */
    @Test
    fun getTvShowDetail() {
        val dummyTvShowEntity = MutableLiveData<ProgrammeEntity>()
        dummyTvShowEntity.value = Data.generateDataMovies()[0]
        `when`(local.getTvShow(tvShowId)).thenReturn(dummyTvShowEntity)

        val tvShow = LiveDataTestUtil.getValue(
            programmeRepository.getProgrammeDetail(
                tvShowId,
                DetailProgrammeActivity.TV_SHOWS_TYPE
            )
        )
        verify(remote).getListTvShow()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.title, tvShow.title)
        assertEquals(dummyTvShow.description, tvShow.description)
        assertEquals(dummyTvShow.yearRelease, tvShow.yearRelease)
        assertEquals(dummyTvShow.releaseDate, tvShow.releaseDate)
        assertEquals(dummyTvShow.numberOfEpisode, tvShow.numberOfEpisode)
        assertEquals(dummyTvShow.ageRating, tvShow.ageRating)
        assertEquals(dummyTvShow.duration, tvShow.duration)
        assertEquals(dummyTvShow.genre, tvShow.genre)
        assertEquals(dummyTvShow.director, tvShow.director)
        assertEquals(dummyTvShow.writer, tvShow.writer)
        assertEquals(dummyTvShow.stars, tvShow.stars)
        assertEquals(dummyTvShow.rating, tvShow.rating)
        assertEquals(dummyTvShow.language, tvShow.language)
    }
}