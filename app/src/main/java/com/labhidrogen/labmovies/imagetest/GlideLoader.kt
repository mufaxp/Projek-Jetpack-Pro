package com.labhidrogen.labmovies.imagetest

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

/*
* Belum dilanjutkan, mohon dihiraukan saja...
* Mohon bantuannya bila ada perbaikan...
*/
class GlideLoader(val context: Context) : LoaderImageNetwork {
    override fun load(
        requestOptions: RequestOptions,
        url: String,
        success: ((drawable: Drawable) -> Unit)?,
        error: ((exception: GlideException?) -> Unit)?,
        ivImageView: ImageView
    ) {
        if (url.isEmpty()) {
            Log.d("TAG", "The url cannot be null")
            return
        }

        Glide.with(context)
            .load(url)
            .apply(requestOptions)
            .addListener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    error?.invoke(e)
                    Log.d("TAG", "onLoadFailed url = $url")
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d("TAG", "onLoadSuccess url = $url")
                    success?.invoke(resource)
                    return false
                }
            })
            .into(ivImageView)
    }
}