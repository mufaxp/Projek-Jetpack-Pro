package com.labhidrogen.labmovies.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.labhidrogen.labmovies.R
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.databinding.ActivityDetailProgrammeBinding
import com.labhidrogen.labmovies.databinding.ContentDetailBinding
import com.labhidrogen.labmovies.viewmodel.ViewModelFactory

class DetailProgrammeActivity : AppCompatActivity() {

    private var _binding: ContentDetailBinding? = null
    private val binding get() = _binding!!
    private var menu: Menu? = null
    private var type: Int = 0
    private var state = false

    private lateinit var viewModel: DetailProgrammeViewModel
    private lateinit var entity: ProgrammeEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailProgrammeBinding = ActivityDetailProgrammeBinding.inflate(layoutInflater)
        _binding = activityDetailProgrammeBinding.detailContent
        setContentView(activityDetailProgrammeBinding.root)

        setSupportActionBar(activityDetailProgrammeBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // defining the viewModel
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailProgrammeViewModel::class.java]

        // get the parcelable data
        val extras = intent.extras
        if (extras != null) {
            val programmeId = extras.getString(EXTRA_PROGRAMME)
            type = extras.getInt(EXTRA_TYPE)
            if (programmeId != null) {
                binding.progressBar.visibility = View.VISIBLE

                viewModel.setSelectedProgramme(programmeId, type)
                viewModel.getProgrammeDetail().observe(this, { entity ->
                    binding.progressBar.visibility = View.GONE
                    this.entity = entity
                    state = entity.bookmarked
                    Log.d("bookmark", "onCreate, Bookmark state: ${entity.bookmarked}, type: $type")
                    populateProgramme(entity)
                })
            }
        }
    }

    private fun populateProgramme(programmeEntity: ProgrammeEntity) {
        with(binding) {
            tvTitle.text = programmeEntity.title
            tvGenre.text = programmeEntity.genre
            tvDescription.text = programmeEntity.description

            Glide.with(this@DetailProgrammeActivity)
                .load(programmeEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imagePoster)
            imagePoster.contentDescription = programmeEntity.title
            tvDirector.text = programmeEntity.director
            tvWriter.text = programmeEntity.writer
            tvStars.text = programmeEntity.stars
            tvReleaseDate.text = programmeEntity.releaseDate
            tvLanguage.text = programmeEntity.language
            tvDuration.text = programmeEntity.duration
            tvEpisodes.text = programmeEntity.numberOfEpisode
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
//        viewModel.getProgrammeDetail().observe(this, { entity ->
//            if (entity != null) {
//                val state = entity.bookmarked
//            }
//        })
        setBookmarkState(state)
        return true
    }

    private fun setState(state: Boolean){
        this.state = !state
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            R.id.action_bookmark -> {
                viewModel.setBookmark(entity)
                setState(state)
                Log.d("bookmark state", "onOptionsItemSelected, state: $state")
                setBookmarkState(state)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setBookmarkState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_bookmark)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmarked)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark)
        }
    }

    companion object {
        const val EXTRA_PROGRAMME = "extra_programme"
        const val EXTRA_TYPE = "type"
        const val MOVIES_TYPE = 1
        const val TV_SHOWS_TYPE = 2
    }
}