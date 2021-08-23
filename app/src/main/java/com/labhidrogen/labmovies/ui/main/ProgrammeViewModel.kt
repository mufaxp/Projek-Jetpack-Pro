package com.labhidrogen.labmovies.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.data.source.ProgrammeRepository
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity
import com.labhidrogen.labmovies.vo.Resource

class ProgrammeViewModel(private val programmeRepository: ProgrammeRepository) : ViewModel() {
    fun getProgramme(type: Int): LiveData<Resource<List<ProgrammeEntity>>> {
        return if (type == DetailProgrammeActivity.MOVIES_TYPE) {
            programmeRepository.getListMovie()
        } else {
            programmeRepository.getListTvShow()
        }
    }
}