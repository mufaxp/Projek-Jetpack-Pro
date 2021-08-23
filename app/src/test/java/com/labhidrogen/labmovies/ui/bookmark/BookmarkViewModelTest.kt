package com.labhidrogen.labmovies.ui.bookmark

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.labhidrogen.labmovies.data.source.ProgrammeRepository
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity.Companion.MOVIES_TYPE
import com.labhidrogen.labmovies.ui.main.ProgrammeViewModel
import com.labhidrogen.labmovies.utils.Data
import com.labhidrogen.labmovies.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookmarkViewModelTest {

    private lateinit var viewModel: BookmarkViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var programmeRepository: ProgrammeRepository

    @Mock
    private lateinit var observer: Observer<List<ProgrammeEntity>>

    @Before
    fun setUp() {
        viewModel = BookmarkViewModel(programmeRepository)
    }

    /*
    * BookmarkedViewModelTest
    * getBookmarkedMovies()
    * 1. Memanipulasi data ketika pemanggilan data movies yang mengandung nilai true pada entitas bookmarked di kelas repository
    * 2. Memastikan metode di kelas repository terpanggil
    * 3. Memastikan data tidak null (kasus : ada 3 data yang memiliki nilai true pada entitas bookmarked)
    * 4. Melakukan pengecekan kesesuaian jumlah bookmarkedMovies
    */
    @Test
    fun getBookmarkedMovies() {
        val dummyProgramme = Data.generateBookmarkedMovies()
        val bookmarkedMovies = MutableLiveData<List<ProgrammeEntity>>()
        bookmarkedMovies.value = dummyProgramme

        `when`(programmeRepository.getBookmarkedMovies()).thenReturn(bookmarkedMovies)
        val entities = viewModel.getBookmarked(MOVIES_TYPE).value
        verify(programmeRepository).getBookmarkedMovies()
        assertNotNull(entities)
        assertEquals(Data.generateBookmarkedMovies().size, entities?.size)

        viewModel.getBookmarked(MOVIES_TYPE).observeForever(observer)
        verify(observer).onChanged(dummyProgramme)
    }
}