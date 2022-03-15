package com.atacanugurlu.spotify.ui.internal.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atacanugurlu.spotify.databinding.HomeFragmentBinding
import com.atacanugurlu.spotify.util.adapter.home.HomeTrackAdapter
import com.atacanugurlu.spotify.util.adapter.library.TrackAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding : HomeFragmentBinding
    private lateinit var recentlyListened : GridLayout
    private lateinit var topBar : LinearLayout
    private lateinit var recyclerViewDiscover : RecyclerView
    private lateinit var recyclerViewTrending : RecyclerView
    private lateinit var recyclerViewEpisodes : RecyclerView
    private lateinit var recyclerViewRecentlyPlayed : RecyclerView
    private lateinit var trendingAlbumsAdapter: HomeTrackAdapter
    private lateinit var episodesAdapter: HomeTrackAdapter
    private lateinit var recentlyPlayedAdapter: HomeTrackAdapter
    private lateinit var discoverAdapter: HomeTrackAdapter
    private lateinit var imageViewBell : ImageView
    private lateinit var imageViewClock : ImageView
    private lateinit var imageViewSettings : ImageView
    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        initializeFragment(inflater)

        return binding.root
    }

    private fun initializeFragment(inflater: LayoutInflater) {
        initializeBinding(inflater)
        initializeRecyclerViews()
        initializeNavigation()
    }

    private fun initializeBinding(inflater: LayoutInflater) {
        binding = HomeFragmentBinding.inflate(inflater)
        bindVariables()
    }

    private fun bindVariables() {
        topBar = binding.linearLayoutTopBar
        imageViewBell = binding.imageViewBell
        imageViewClock = binding.imageViewClock
        imageViewSettings = binding.imageViewSettings
        recentlyListened = binding.gridLayoutRecentlyListened
        recyclerViewTrending = binding.recyclerTrendingAlbums
        recyclerViewEpisodes = binding.recyclerEpisodes
        recyclerViewRecentlyPlayed = binding.recyclerRecentlyPlayed
        recyclerViewDiscover = binding.recyclerDiscover
    }

    private fun initializeRecyclerViews() {
        initializeTrendingAlbumsRecyclerView()
        initializeEpisodesRecyclerView()
        initializeRecentlyPlayedRecyclerView()
        initializeDiscoverRecyclerView()
    }

    private fun initializeTrendingAlbumsRecyclerView() {

        setLinearLayout(recyclerViewTrending)
        setTrendingAlbumsAdapter()
        setTrendingAlbumsListener()

    }

    private fun setTrendingAlbumsAdapter() {
        trendingAlbumsAdapter = HomeTrackAdapter()
        recyclerViewTrending.adapter = trendingAlbumsAdapter
    }

    private fun setTrendingAlbumsListener() {
        viewModel.getTracks().observe(viewLifecycleOwner) { tracksList ->
            trendingAlbumsAdapter.submitList(tracksList)
        }
        viewModel.getSearchedTracks("Green")
    }



    private fun initializeEpisodesRecyclerView() {

        setLinearLayout(recyclerViewEpisodes)
        setEpisodesAdapter()
        setEpisodesListener()

    }

    private fun setEpisodesAdapter() {
        episodesAdapter = HomeTrackAdapter()
        recyclerViewEpisodes.adapter = episodesAdapter
    }

    private fun setEpisodesListener() {
        viewModel.getTracks().observe(viewLifecycleOwner) { tracksList ->
            episodesAdapter.submitList(tracksList)
        }
        viewModel.getSearchedTracks("Green")
    }



    private fun initializeRecentlyPlayedRecyclerView() {
        setLinearLayout(recyclerViewRecentlyPlayed)
        setRecentlyPlayedAdapter()
        setRecentlyPlayedListener()

    }

    private fun setRecentlyPlayedAdapter() {
        recentlyPlayedAdapter = HomeTrackAdapter()
        recyclerViewRecentlyPlayed.adapter = recentlyPlayedAdapter
    }

    private fun setRecentlyPlayedListener() {
        viewModel.getTracks().observe(viewLifecycleOwner) { tracksList ->
            recentlyPlayedAdapter.submitList(tracksList)
        }
        viewModel.getSearchedTracks("Red")
    }



    private fun initializeDiscoverRecyclerView() {
        setLinearLayout(recyclerViewDiscover)
        setDiscoverAdapter()
        setDiscoverListener()
    }

    private fun setDiscoverAdapter() {
        discoverAdapter = HomeTrackAdapter()
        recyclerViewDiscover.adapter = discoverAdapter
    }

    private fun setDiscoverListener() {
        viewModel.getTracks().observe(viewLifecycleOwner) { tracksList ->
            discoverAdapter.submitList(tracksList)
        }
        viewModel.getSearchedTracks("Blue")
    }


    private fun setLinearLayout(recyclerView: RecyclerView) {
        val linearLayoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerView.layoutManager = linearLayoutManager
    }

    private fun initializeNavigation() {
    }

}