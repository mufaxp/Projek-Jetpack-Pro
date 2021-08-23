package com.labhidrogen.labmovies.ui.bookmark

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.labhidrogen.labmovies.R
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.databinding.FragmentBookmarkBinding
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity.Companion.MOVIES_TYPE
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity.Companion.TV_SHOWS_TYPE
import com.labhidrogen.labmovies.ui.main.ProgrammeFragmentCallback
import com.labhidrogen.labmovies.viewmodel.ViewModelFactory

class BookmarkFragment : Fragment(), ProgrammeFragmentCallback {

    //using lateinit make the resource leakable
    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: BookmarkViewModel
    private lateinit var bookmarkAdapter: BookmarkAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentBookmarkBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val type = arguments?.getInt(ARG_SECTION_NUMBER, 0)
            bookmarkAdapter = BookmarkAdapter(this)

            // defining the factory and view model
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(this, factory)[BookmarkViewModel::class.java]
            binding.bookmarkProgressBar.visibility = View.VISIBLE
            when (type) {
                1 -> obtainData(MOVIES_TYPE)
                else -> obtainData(TV_SHOWS_TYPE)
            }

            with(binding.rvListBookmark) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = bookmarkAdapter
            }
        }
    }

    // a method for obtain data from view model
    private fun obtainData(type: Int) {
        viewModel.getBookmarked(type).observe(viewLifecycleOwner, {
            if (it != null) {
                binding.bookmarkProgressBar.visibility = View.GONE
                bookmarkAdapter.setBookmark(it, type)
                Log.d("bookmarked", "size: ${it.size}")
                bookmarkAdapter.notifyDataSetChanged()
            }
        })
    }

    override fun onShareClick(entity: ProgrammeEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Share")
                .setText(resources.getString(R.string.share_text, entity.title))
                .startChooser()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(position: Int) =
            BookmarkFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, position)
                }
            }
    }
}