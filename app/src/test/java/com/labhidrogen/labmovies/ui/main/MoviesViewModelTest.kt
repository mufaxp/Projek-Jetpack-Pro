package com.labhidrogen.labmovies.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.data.source.ProgrammeRepository
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity
import com.labhidrogen.labmovies.utils.Data
import com.labhidrogen.labmovies.vo.Resource
import org.junit.Assert.*
import org.junit.Test
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: ProgrammeViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var programmeRepository: ProgrammeRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<ProgrammeEntity>>>

    @Before
    fun setUp() {
        viewModel = ProgrammeViewModel(programmeRepository)
    }

    /*
    * MoviesViewModelTest
    * 1. Memanipulasi data ketika pemanggilan data movies di kelas repository
    * 2. Memastikan metode di kelas repository terpanggil
    * 3. Melakukan pengecekan data movie tidak null
    * 4. Melakukan pengecekan kesesuaian jumlah data movies
    */
    @Test
    fun getMovies() {
        val dummyProgramme = Resource.success(Data.generateDataMovies())
        val movies = MutableLiveData<Resource<List<ProgrammeEntity>>>()
        movies.value = dummyProgramme

        `when`(programmeRepository.getListMovie()).thenReturn(movies)
        val entities = viewModel.getProgramme(DetailProgrammeActivity.MOVIES_TYPE).value?.data
        verify(programmeRepository).getListMovie()
        assertNotNull(entities)
        assertEquals(Data.generateDataMovies().size, entities?.size)

        viewModel.getProgramme(DetailProgrammeActivity.MOVIES_TYPE).observeForever(observer)
        verify(observer).onChanged(dummyProgramme)
    }
}