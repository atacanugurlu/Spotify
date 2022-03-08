package com.atacanugurlu.spotify.util.adapter.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atacanugurlu.spotify.data.model.music.Artist
import com.atacanugurlu.spotify.databinding.RecyclerItemLibraryArtistBinding


class ArtistAdapter : ListAdapter<Artist, ArtistAdapter.ArtistViewHolder>(ArtistDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerItemLibraryArtistBinding.inflate(layoutInflater, parent, false)
        return ArtistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ArtistViewHolder(
        val binding: RecyclerItemLibraryArtistBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: Artist) {
            binding.textViewAlbumTitle.text = artist.name
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