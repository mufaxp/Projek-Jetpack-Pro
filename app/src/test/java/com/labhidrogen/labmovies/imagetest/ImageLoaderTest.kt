package com.labhidrogen.labmovies.imagetest

import android.widget.ImageView
import com.labhidrogen.labmovies.R
import com.labhidrogen.labmovies.utils.Data
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/*
* Belum dilanjutkan, mohon dihiraukan saja...
* Mohon bantuannya bila ada perbaikan...
*/
@RunWith(JUnit4::class)
class ImageLoaderTest {

    private lateinit var imageLoader: ImageLoader
//    private val testModule = module {
//        single { named("test") }
//    }

    @Before
    fun before() {
//        loadKoinModules(testModule)

    }

    @Test
    fun imageLoaderSuccess() {
        val imageView = mock<ImageView>()

        imageLoader.network {
            url { Data.generateDataMovies()[0].imagePath }
            error { PLACE_HOLDER_ID }
            errorCallback { { Assert.fail("The image loader must return an success ${it?.message}") } }
            successCallback { {} }
        }.load(imageView)

        verify {
            imageView.setTag(
                ImageLoader.IMAGE_LOADER_TAG,
                ImageLoader.StateLoaded.LoadedFromNetwork(
                    Data.generateDataMovies()[0].imagePath,
                    PLACE_HOLDER_ID,
                    PLACE_HOLDER_ID,
                    true
                )
            )
        }
    }

    companion object {
        const val PLACE_HOLDER_ID = R.drawable.ic_loading
    }
}