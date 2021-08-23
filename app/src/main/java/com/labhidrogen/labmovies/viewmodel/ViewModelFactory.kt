package com.labhidrogen.labmovies.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.labhidrogen.labmovies.data.source.ProgrammeRepository
import com.labhidrogen.labmovies.injection.Injection
import com.labhidrogen.labmovies.ui.bookmark.BookmarkViewModel
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeViewModel
import com.labhidrogen.labmovies.ui.main.ProgrammeViewModel

class ViewModelFactory private constructor(private val mProgrammeRepository: ProgrammeRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ProgrammeViewModel::class.java) -> {
                ProgrammeViewModel(mProgrammeRepository) as T
            }
            modelClass.isAssignableFrom(DetailProgrammeViewModel::class.java) -> {
                DetailProgrammeViewModel(mProgrammeRepository) as T
            }
            modelClass.isAssignableFrom(BookmarkViewModel::class.java) -> {
                BookmarkViewModel(mProgrammeRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel Class ${modelClass.name}")
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }
}