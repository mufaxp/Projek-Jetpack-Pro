package com.labhidrogen.labmovies.imagetest

import android.graphics.drawable.Drawable
import android.util.Log
import android.webkit.URLUtil
import android.widget.ImageView
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestOptions

/*
* Belum dilanjutkan, mohon dihiraukan saja...
* Mohon bantuannya bila ada perbaikan...
*/
class TestLoaderImageNetwork() : LoaderImageNetwork {
    override fun load(
        requestOptions: RequestOptions,
        url: String,
        success: ((drawable: Drawable) -> Unit)?,
        error: ((exception: GlideException?) -> Unit)?,
        ivImageView: ImageView
    ) {
        if (url.isEmpty() || !URLUtil.isValidUrl(url)) {
            Log.d("TAG", "The url cannot be null")
            setTag(
                ivImageView, ImageLoader.StateLoaded.LoadedFromNetwork(
                    url,
                    requestOptions.placeholderId,
                    requestOptions.errorId,
                    false
                )
            )
            return
        } else {
            setTag(ivImageView,ImageLoader.StateLoaded.LoadedFromNetwork(
                url,
                requestOptions.placeholderId,
                requestOptions.errorId,
                true
            ))
        }
    }

    private fun setTag(iv: ImageView, state: ImageLoader.StateLoaded) {
        iv.tag = ImageLoader.IMAGE_LOADER_TAG
    }
}