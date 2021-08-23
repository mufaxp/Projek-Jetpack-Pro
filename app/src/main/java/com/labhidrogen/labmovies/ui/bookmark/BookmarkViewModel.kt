package com.labhidrogen.labmovies.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.labhidrogen.labmovies.data.source.ProgrammeRepository
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity

class BookmarkViewModel(private val programmeRepository: ProgrammeRepository) : ViewModel() {
    fun getBookmarked(type: Int): LiveData<List<ProgrammeEntity>> {
        return if (type == DetailProgrammeActivity.MOVIES_TYPE) {
            programmeRepository.getBookmarkedMovies()
        } else {
            programmeRepository.getBookmarkedTvShows()
        }
    }
}