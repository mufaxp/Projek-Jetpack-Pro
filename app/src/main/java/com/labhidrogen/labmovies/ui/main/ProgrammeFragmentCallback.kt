package com.labhidrogen.labmovies.ui.main

import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity

interface ProgrammeFragmentCallback {
    fun onShareClick(entity: ProgrammeEntity)
}
