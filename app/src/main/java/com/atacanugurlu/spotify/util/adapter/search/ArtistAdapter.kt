package com.atacanugurlu.spotify.util.adapter.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atacanugurlu.spotify.data.model.music.Artist
import com.atacanugurlu.spotify.databinding.RecyclerItemArtistBinding
import com.atacanugurlu.spotify.util.loader.ImageLoader


class ArtistAdapter : ListAdapter<Artist, ArtistAdapter.ArtistViewHolder>(ArtistDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerItemArtistBinding.inflate(layoutInflater, parent, false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ArtistViewHolder(
        val binding: RecyclerItemArtistBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: Artist) {
            ImageLoader.provideGlide(
                itemView.context,
                "${artist.picture}",
                binding.imageViewCover
            )
            binding.textViewAlbumTitle.text = artist.name
            binding.textViewType.text = "Artist"
        }
    }
}

class ArtistDiffCallback : DiffUtil.ItemCallback<Artist>() {
    override fun areItemsTheSame(oldItem: Artist, newItem: Artist): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Artist, newItem: Artist): Boolean {
        return oldItem == newItem
    }

}