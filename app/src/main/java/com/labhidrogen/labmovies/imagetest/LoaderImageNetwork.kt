package com.labhidrogen.labmovies.imagetest

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestOptions

/*
* Belum dilanjutkan, mohon dihiraukan saja...
* Mohon bantuannya bila ada perbaikan...
*/
interface LoaderImageNetwork {

    fun load(
        requestOptions: RequestOptions,
        url: String = "",
        success: ((drawable: Drawable) -> Unit)? = null,
        error: ((exception: GlideException?) -> Unit)? = null,
        ivImageView: ImageView
    )
}