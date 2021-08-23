package com.labhidrogen.labmovies.imagetest

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestOptions

/*
* Belum dilanjutkan, mohon dihiraukan saja...
* Mohon bantuannya bila ada perbaikan...
*/
class ImageLoader(val context: Context, val networkLoader: LoaderImageNetwork) {

    fun network(init: FromNetwork.() -> Unit): FromNetwork {
        return FromNetwork(init)
    }

    inner class FromNetwork private constructor() {
        constructor(init: FromNetwork.() -> Unit) : this() {
            init()
        }

        private var url: String = ""
        private var placeHolder: Int? = null
        private var errorPlaceHolder: Int? = null
        private var success: ((drawable: Drawable) -> Unit)? = null
        private var error: ((exception: GlideException?) -> Unit)? = null

        fun url(init: () -> String) {
            url = init()
        }

        fun error(init: () -> Int) {
            errorPlaceHolder = init()
        }

        fun placeHolder(init: () -> Int) {
            placeHolder = init()
        }

        fun successCallback(init: () -> ((drawable: Drawable) -> Unit)) = apply { this.success = init() }

        fun errorCallback(init: () -> ((exception: GlideException?) -> Unit)) = apply { this.error = init() }

        fun load(imageView: ImageView) {
            Log.d("TAG", "Loading image $url in ${imageView.id}")
            val options = RequestOptions()
            placeHolder?.let { options.placeholder(it) }
            errorPlaceHolder?.let { options.error(it) }
            placeHolder?.let { options.placeholder(it) }

            networkLoader.load(options, url, success, error, imageView)
        }
    }

    sealed class StateLoaded {
        data class LoadedFromNetwork(
            val url: String,
            val placeHolder: Int? = null,
            val errorPlaceHolder: Int? = null,
            val success: Boolean
        ) : StateLoaded()
    }

    companion object {
        const val IMAGE_LOADER_TAG = 0
    }
}