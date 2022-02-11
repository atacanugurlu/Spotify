package com.atacanugurlu.spotify.ui.internal.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atacanugurlu.spotify.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding : HomeFragmentBinding
    private lateinit var recentlyListenedLayoutManager: GridLayoutManager
    private lateinit var recentlyListened : RecyclerView
    private lateinit var topBar : LinearLayout
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
        initializeLayouts()
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
        recentlyListened = binding.recyclerViewLiked
    }

    private fun initializeLayouts() {
        setRecentlyListenedLayout()
    }

    private fun setRecentlyListenedLayout() {
        recentlyListenedLayoutManager = GridLayoutManager(activity, 2)
        recentlyListened.layoutManager = recentlyListenedLayoutManager
    }

    private fun initializeNavigation() {
    }

}