package com.atacanugurlu.spotify.util.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atacanugurlu.spotify.data.model.music.Track
import com.atacanugurlu.spotify.databinding.RecyclerItemRecentlyPlayedSongBinding
import com.atacanugurlu.spotify.util.loader.ImageLoader

class HomeTrackAdapter : ListAdapter<Track, HomeTrackAdapter.TrackViewHolder>(TrackDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerItemRecentlyPlayedSongBinding.inflate(layoutInflater, parent, false)
        return TrackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class TrackViewHolder(
        val binding: RecyclerItemRecentlyPlayedSongBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(track: Track) {
            ImageLoader.provideGlide(
                itemView.context,
                "${track.explicitContentCover}",
                binding.imageViewCover
            )
            binding.textViewAlbumTitle.text = track.title
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
