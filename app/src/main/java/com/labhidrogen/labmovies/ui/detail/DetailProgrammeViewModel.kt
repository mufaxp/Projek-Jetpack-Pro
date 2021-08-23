package com.labhidrogen.labmovies.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.data.source.ProgrammeRepository

class DetailProgrammeViewModel(private val programmeRepository: ProgrammeRepository) : ViewModel() {
//    private val programmeId = MutableLiveData<String>()
    private lateinit var programmeId:String
    private var type: Int = 0
//    private lateinit var id: String

    fun setSelectedProgramme(programmeId: String, type: Int) {
        this.programmeId = programmeId
        this.type = type
    }

    fun getProgrammeDetail(): LiveData<ProgrammeEntity>{
        return programmeRepository.getProgrammeDetail(programmeId, type)
    }

    fun setBookmark(entity: ProgrammeEntity?) {
        if (entity != null) {
            val newState = !entity.bookmarked
            if (type == DetailProgrammeActivity.MOVIES_TYPE) {
                programmeRepository.setMovieBookmark(entity, newState)
            } else {
                programmeRepository.setTvShowBookmark(entity, newState)
            }
        }
    }
}