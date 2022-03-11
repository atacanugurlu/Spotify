package com.atacanugurlu.spotify.ui.internal.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atacanugurlu.spotify.databinding.LibraryFragmentBinding
import com.atacanugurlu.spotify.util.adapter.library.TrackAdapter
import com.atacanugurlu.spotify.util.adapter.search.ArtistAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LibraryFragment : Fragment() {

    private lateinit var binding: LibraryFragmentBinding
    private lateinit var recyclerViewLibrary : RecyclerView
    private lateinit var trackAdapter: TrackAdapter
    private lateinit var tracksLinearLayoutManager: LinearLayoutManager
    private val viewModel: LibraryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        initializeFragment(inflater)


        return binding.root
    }

    private fun initializeFragment(inflater: LayoutInflater) {
        initializeBinding(inflater)
        initializeRecyclerView()
        initializeNavigation()
    }

    private fun initializeBinding(inflater: LayoutInflater) {
        binding = LibraryFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        bindVariables()
    }

    private fun bindVariables() {
        recyclerViewLibrary = binding.recyclerViewLibrary
    }

    private fun initializeRecyclerView() {
        initializeLinearLayout()
        initializeAdapter()
        initializeListener()
    }

    private fun initializeLinearLayout() {
        tracksLinearLayoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerViewLibrary.layoutManager = tracksLinearLayoutManager
    }

    private fun initializeAdapter() {
        trackAdapter = TrackAdapter()
        recyclerViewLibrary.adapter = trackAdapter
    }

    private fun initializeListener() {
        viewModel.getFavouriteTracks().observe(viewLifecycleOwner) { tracksList ->
            trackAdapter.submitList(tracksList)
        }
    }

    private fun initializeNavigation() {
    }

}