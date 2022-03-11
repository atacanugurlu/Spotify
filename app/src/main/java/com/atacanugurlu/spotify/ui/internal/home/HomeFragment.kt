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
    private lateinit var trackAdapter: HomeTrackAdapter
    private lateinit var tracksLinearLayoutManager: LinearLayoutManager
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
        recyclerViewDiscover = binding.recyclerDiscover
    }

    private fun initializeRecyclerViews() {
        initializeDiscoverRecyclerView()
    }

    private fun initializeDiscoverRecyclerView() {
        setDiscoverLinearLayout()
        setDiscoverAdapter()
        setDiscoverListener()
    }

    private fun setDiscoverLinearLayout() {
        tracksLinearLayoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        recyclerViewDiscover.layoutManager = tracksLinearLayoutManager
    }

    private fun setDiscoverAdapter() {
        trackAdapter = HomeTrackAdapter()
        recyclerViewDiscover.adapter = trackAdapter
    }

    private fun setDiscoverListener() {
        viewModel.getTracks().observe(viewLifecycleOwner) { tracksList ->
            trackAdapter.submitList(tracksList)
        }
        viewModel.getSearchedTracks("Red")
    }


    private fun initializeNavigation() {
    }

}