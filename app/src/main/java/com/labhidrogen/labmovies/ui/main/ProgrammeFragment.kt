package com.labhidrogen.labmovies.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.labhidrogen.labmovies.R
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.databinding.FragmentProgrammeBinding
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity.Companion.MOVIES_TYPE
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity.Companion.TV_SHOWS_TYPE
import com.labhidrogen.labmovies.viewmodel.ViewModelFactory
import com.labhidrogen.labmovies.vo.Status

class ProgrammeFragment : Fragment(), ProgrammeFragmentCallback {
    private var _binding: FragmentProgrammeBinding? = null
    private val binding get() = _binding!!

    private lateinit var programmeViewModel: ProgrammeViewModel
    private lateinit var programmeAdapter: ProgrammeAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgrammeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val type = arguments?.getInt(ARG_SECTION_NUMBER, 0)
            programmeAdapter = ProgrammeAdapter(this)
            val factory = ViewModelFactory.getInstance(requireActivity())
            programmeViewModel =
                ViewModelProvider(this, factory)[ProgrammeViewModel::class.java]
            binding.progressBar.visibility = View.VISIBLE
            when (type) {
                1 -> {
                    obtainData(MOVIES_TYPE)
                }
                else -> {
                    obtainData(TV_SHOWS_TYPE)
                }
            }
            with(binding.rvListProgramme) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = programmeAdapter
            }
        }
    }

    private fun obtainData(type: Int) {
        programmeViewModel.getProgramme(type).observe(viewLifecycleOwner, {
            if (it != null) {
                when (it.status) {
                    Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        programmeAdapter.setProgramme(it.data, type)
                        programmeAdapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
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

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(index: Int) =
            ProgrammeFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }
}