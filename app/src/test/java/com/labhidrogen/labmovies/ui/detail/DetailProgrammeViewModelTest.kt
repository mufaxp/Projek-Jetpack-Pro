package com.labhidrogen.labmovies.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.data.source.ProgrammeRepository
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity.Companion.MOVIES_TYPE
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity.Companion.TV_SHOWS_TYPE
import com.labhidrogen.labmovies.utils.Data
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailProgrammeViewModelTest {

    private lateinit var moviesViewModel: DetailProgrammeViewModel
    private lateinit var tvShowsViewModel: DetailProgrammeViewModel
    private val dummyProgrammeMovie = Data.generateDataMovies()[0]
    private val dummyProgrammeTvShows = Data.generateDataTvShow()[0]
    private val movieId = dummyProgrammeMovie.programmeId
    private val tvShowId = dummyProgrammeTvShows.programmeId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var programmeRepository: ProgrammeRepository

    @Mock
    private lateinit var programmeObserver: Observer<ProgrammeEntity>

    @Before
    fun setUp() {
        moviesViewModel = DetailProgrammeViewModel(programmeRepository)
        moviesViewModel.setSelectedProgramme(movieId, MOVIES_TYPE)
        tvShowsViewModel = DetailProgrammeViewModel(programmeRepository)
    }

    /*
    * DetailProgrammeViewModelTest
    * getMovieDetail()
    * 1. Memanipulasi data ketika pemanggilan data spesifik di kelas repository
    * 2. Memastikan metode di kelas repository terpanggil
    * 3. Melakukan pengecekan data tidak null
    * 4. Membandingkan kesesuaian data dengan yang diharapkan
    */
    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<ProgrammeEntity>()
        movie.value = dummyProgrammeMovie

        `when`(programmeRepository.getProgrammeDetail(movieId, MOVIES_TYPE)).thenReturn(movie)
        moviesViewModel.setSelectedProgramme(movieId, MOVIES_TYPE)

        val movieEntity = moviesViewModel.getProgrammeDetail().value as ProgrammeEntity
        verify(programmeRepository).getProgrammeDetail(movieId, MOVIES_TYPE)

        assertNotNull(movieEntity)
        assertEquals(dummyProgrammeMovie.title, movieEntity.title)
        assertEquals(dummyProgrammeMovie.description, movieEntity.description)
        assertEquals(dummyProgrammeMovie.yearRelease, movieEntity.yearRelease)
        assertEquals(dummyProgrammeMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyProgrammeMovie.numberOfEpisode, movieEntity.numberOfEpisode)
        assertEquals(dummyProgrammeMovie.ageRating, movieEntity.ageRating)
        assertEquals(dummyProgrammeMovie.duration, movieEntity.duration)
        assertEquals(dummyProgrammeMovie.genre, movieEntity.genre)
        assertEquals(dummyProgrammeMovie.director, movieEntity.director)
        assertEquals(dummyProgrammeMovie.writer, movieEntity.writer)
        assertEquals(dummyProgrammeMovie.stars, movieEntity.stars)
        assertEquals(dummyProgrammeMovie.rating, movieEntity.rating)
        assertEquals(dummyProgrammeMovie.language, movieEntity.language)

        moviesViewModel.getProgrammeDetail().observeForever(programmeObserver)
        verify(programmeObserver).onChanged(dummyProgrammeMovie)
    }

    /*
    * DetailProgrammeViewModelTest
    * getTvShowDetail()
    * 1. Memanipulasi data ketika pemanggilan data spesifik di kelas repository
    * 2. Memastikan metode di kelas repository terpanggil
    * 3. Melakukan pengecekan data tidak null
    * 4. Membandingkan kesesuaian data dengan yang diharapkan
    */
    @Test
    fun getTvShowDetail() {
        val tvShow = MutableLiveData<ProgrammeEntity>()
        tvShow.value = dummyProgrammeTvShows

        `when`(programmeRepository.getProgrammeDetail(tvShowId, TV_SHOWS_TYPE)).thenReturn(tvShow)
        tvShowsViewModel.setSelectedProgramme(tvShowId, TV_SHOWS_TYPE)
        val tvShowEntity = tvShowsViewModel.getProgrammeDetail().value as ProgrammeEntity
        verify(programmeRepository).getProgrammeDetail(tvShowId, TV_SHOWS_TYPE)
        assertNotNull(tvShowEntity)
        assertEquals(dummyProgrammeTvShows.title, tvShowEntity.title)
        assertEquals(dummyProgrammeTvShows.description, tvShowEntity.description)
        assertEquals(dummyProgrammeTvShows.yearRelease, tvShowEntity.yearRelease)
        assertEquals(dummyProgrammeTvShows.releaseDate, tvShowEntity.releaseDate)
        assertEquals(dummyProgrammeTvShows.numberOfEpisode, tvShowEntity.numberOfEpisode)
        assertEquals(dummyProgrammeTvShows.ageRating, tvShowEntity.ageRating)
        assertEquals(dummyProgrammeTvShows.duration, tvShowEntity.duration)
        assertEquals(dummyProgrammeTvShows.genre, tvShowEntity.genre)
        assertEquals(dummyProgrammeTvShows.director, tvShowEntity.director)
        assertEquals(dummyProgrammeTvShows.writer, tvShowEntity.writer)
        assertEquals(dummyProgrammeTvShows.stars, tvShowEntity.stars)
        assertEquals(dummyProgrammeTvShows.rating, tvShowEntity.rating)
        assertEquals(dummyProgrammeTvShows.language, tvShowEntity.language)

        tvShowsViewModel.getProgrammeDetail().observeForever(programmeObserver)
        verify(programmeObserver).onChanged(dummyProgrammeTvShows)
    }

    /*
    * DetailProgrammeViewModelTest
    * setBookmark()
    * 1. Memanipulasi pemanggilan setMovieBookmark() pada saat akan menyimpan data
    * 2. Memanipulasi data ketika data tersebut diminta
    * 3. Memastikan metode getProgrammeDetail() terpanggil
    * 4. Membandingkan kesesuaian data bookmarked dengan yang diharapkan*/
    @Test
    fun setBookmark() {
        val entity = dummyProgrammeMovie
        doNothing().`when`(
            programmeRepository
        ).setMovieBookmark(
            dummyProgrammeMovie,
            dummyProgrammeMovie.bookmarked
        )
        moviesViewModel.setBookmark(entity)

        val movie = MutableLiveData<ProgrammeEntity>()
        movie.value = Data.setBookmarkMovie(dummyProgrammeMovie, true)
        `when`(programmeRepository.getProgrammeDetail(movieId, MOVIES_TYPE)).thenReturn(movie)

        val movieEntity = moviesViewModel.getProgrammeDetail().value as ProgrammeEntity
        verify(programmeRepository).getProgrammeDetail(movieId, MOVIES_TYPE)
        assertEquals(true, movieEntity.bookmarked)
    }
}
