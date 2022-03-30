package com.atacanugurlu.spotify.domain.interactor.adapter.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atacanugurlu.spotify.domain.model.music.Track
import com.atacanugurlu.spotify.databinding.RecyclerItemTrackBinding
import com.atacanugurlu.spotify.domain.util.loader.ImageLoader

class TrackAdapter : ListAdapter<Track, TrackAdapter.TrackViewHolder>(TrackDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerItemTrackBinding.inflate(layoutInflater, parent, false)
        return TrackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class TrackViewHolder(
        val binding: RecyclerItemTrackBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(track: Track) {
            ImageLoader.provideGlide(
                itemView.context,
                "${track.explicitContentCover}",
                binding.imageViewTrackCover
            )
            binding.textViewTrackName.text = track.title
            binding.textViewArtist.text = "Artist" // need artist field
        }
    }
}

class TrackDiffCallback : DiffUtil.ItemCallback<Track>() {
    override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
        return oldItem == newItem
    }
}
