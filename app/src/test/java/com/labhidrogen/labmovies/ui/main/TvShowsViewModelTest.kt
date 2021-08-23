package com.labhidrogen.labmovies.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.data.source.ProgrammeRepository
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity
import com.labhidrogen.labmovies.utils.Data
import com.labhidrogen.labmovies.vo.Resource
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
class TvShowsViewModelTest {

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
    * TvShowsViewModelTest
    * 1. Memanipulasi data ketika pemanggilan data tvShows di kelas repository
    * 2. Memastikan metode di kelas repository terpanggil
    * 3. Melakukan pengecekan data tvShows tidak null
    * 4. Melakukan pengecekan kesesuaian jumlah data tvShows
    */
    @Test
    fun getShows() {
        val dummyProgramme = Resource.success(Data.generateDataTvShow())
        val tvShows = MutableLiveData<Resource<List<ProgrammeEntity>>>()
        tvShows.value = dummyProgramme

        `when`(programmeRepository.getListTvShow()).thenReturn(tvShows)
        val entities = viewModel.getProgramme(DetailProgrammeActivity.TV_SHOWS_TYPE).value?.data
        verify(programmeRepository).getListTvShow()
        assertNotNull(entities)
        assertEquals(Data.generateDataTvShow().size, entities?.size)

        viewModel.getProgramme(DetailProgrammeActivity.TV_SHOWS_TYPE).observeForever(observer)
        verify(observer).onChanged(dummyProgramme)
    }
}