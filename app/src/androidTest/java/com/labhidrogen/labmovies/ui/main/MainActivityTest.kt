package com.labhidrogen.labmovies.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.labhidrogen.labmovies.R
import com.labhidrogen.labmovies.imagetest.ImageLoader
import com.labhidrogen.labmovies.utils.Data
import com.labhidrogen.labmovies.utils.EspressoIdlingResource
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    private val moviesData = Data.generateDataMovies()
    private val tvShowsData = Data.generateDataTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    /*
    * Menampilkan data movies
    * 1. Memastikan rv_movies dalam keadaan tampil
    * 2. Gulir rv_movies ke posisi data terakhir
    */
    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_list_programme)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_list_programme)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                moviesData.size
            )
        )
    }

    /*
    * Menampilkan data detail movies
    * 1. Memberi tindakan klik pada data pertama di rv_movies
    * 2. Memastikan setiap komponen data detail tampil sesuai dengan yang diharapkan
    * 3. Memastikan rv_detail dalam keadaan tampil
    */
    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_list_programme)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(moviesData[0].title)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(moviesData[0].genre)))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(withText(moviesData[0].description)))
        onView(withId(R.id.rv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_director)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_director)).check(matches(withText(moviesData[0].director)))
        onView(withId(R.id.tv_writer)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_writer)).check(matches(withText(moviesData[0].writer)))
        onView(withId(R.id.tv_stars)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_stars)).check(matches(withText(moviesData[0].stars)))
        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(withText(moviesData[0].releaseDate)))
        onView(withId(R.id.tv_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_language)).check(matches(withText(moviesData[0].language)))
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(moviesData[0].duration)))
        onView(withId(R.id.tv_episodes)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_episodes)).check(matches(withText(moviesData[0].numberOfEpisode)))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
    }

    /*
    * Menampilkan data tvShows
    * 1. Memastikan rv_tv_shows dalam keadaan tampil
    * 2. Gulir rv_tv_shows ke posisi data terakhir
    */
    @Test
    fun loadTvShows() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_list_programme)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_list_programme)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                tvShowsData.size
            )
        )
    }

    /*
    * Menampilkan data detail tvShows
    * 1. Memberi tindakan klik pada data pertama di rv_tv_shows
    * 2. Memastikan setiap komponen data detail tampil sesuai dengan yang diharapkan
    * 3. Memastikan rv_detail dalam keadaan tampil
    */
    @Test
    fun loadDetailTvShows() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_list_programme)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(tvShowsData[0].title)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(tvShowsData[0].genre)))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(withText(tvShowsData[0].description)))
        onView(withId(R.id.rv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_director)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_director)).check(matches(withText(tvShowsData[0].director)))
        onView(withId(R.id.tv_writer)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_writer)).check(matches(withText(tvShowsData[0].writer)))
        onView(withId(R.id.tv_stars)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_stars)).check(matches(withText(tvShowsData[0].stars)))
        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(withText(tvShowsData[0].releaseDate)))
        onView(withId(R.id.tv_language)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_language)).check(matches(withText(tvShowsData[0].language)))
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(tvShowsData[0].duration)))
        onView(withId(R.id.tv_episodes)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_episodes)).check(matches(withText(tvShowsData[0].numberOfEpisode)))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
    }

    /*
    * Belum dilanjutkan, mohon dihiraukan saja...
    * Mohon bantuannya bila ada perbaikan...
    */
    private fun withImageLoaded(state: ImageLoader.StateLoaded): Matcher<View> {
        return object : BoundedMatcher<View, View>(View::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("view has a ImageLoaded tag equals to $state")
            }

            override fun matchesSafely(item: View): Boolean {
                val tag: ImageLoader.StateLoaded? =
                    (item.getTag(ImageLoader.IMAGE_LOADER_TAG) as? ImageLoader.StateLoaded)
                return (tag != null && state == tag)
            }
        }
    }
}