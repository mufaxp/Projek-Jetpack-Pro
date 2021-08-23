package com.labhidrogen.labmovies.ui.bookmark

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.labhidrogen.labmovies.R
import com.labhidrogen.labmovies.data.source.local.entity.ProgrammeEntity
import com.labhidrogen.labmovies.databinding.ItemsProgrammeBinding
import com.labhidrogen.labmovies.ui.detail.DetailProgrammeActivity
import com.labhidrogen.labmovies.ui.main.ProgrammeFragmentCallback

class BookmarkAdapter(private val callback: ProgrammeFragmentCallback) :
    RecyclerView.Adapter<BookmarkAdapter.ViewHolder>() {
    private var listBookmark = ArrayList<ProgrammeEntity>()
    private var type = 0

    fun setBookmark(bookmarks: List<ProgrammeEntity>?, type: Int) {
        if (bookmarks == null) return
        this.listBookmark.clear()
        this.listBookmark.addAll(bookmarks)
        this.type = type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemsProgrammeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listBookmark[position])
    }

    override fun getItemCount(): Int = listBookmark.size

    inner class ViewHolder(private val binding: ItemsProgrammeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(entity: ProgrammeEntity) {
            with(binding) {
                tvItemTitle.text = entity.title
                tvItemYear.text = entity.yearRelease
                tvItemAgeRating.text = entity.ageRating
                tvItemRating.text = entity.rating
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailProgrammeActivity::class.java)
                    intent.putExtra(DetailProgrammeActivity.EXTRA_PROGRAMME, entity.programmeId)
                    intent.putExtra(DetailProgrammeActivity.EXTRA_TYPE, type)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(entity) }
                Glide.with(itemView.context)
                    .load(entity.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }
}