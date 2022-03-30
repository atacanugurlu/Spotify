package com.atacanugurlu.spotify.presentation.ui.internal.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atacanugurlu.spotify.databinding.SearchFragmentBinding
import com.atacanugurlu.spotify.domain.interactor.adapter.search.ArtistAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: SearchFragmentBinding
    private lateinit var recyclerViewSearch: RecyclerView
    private lateinit var artistAdapter: ArtistAdapter
    private lateinit var artistsLinearLayoutManager: LinearLayoutManager
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        initializeFragment(inflater)

        return binding.root
    }

    private fun initializeFragment(inflater: LayoutInflater) {
        initializeBinding(inflater)
        initializeRecyclerView()
    }

    private fun initializeBinding(inflater: LayoutInflater) {
        binding = SearchFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        bindVariables()
    }

    private fun bindVariables() {
        recyclerViewSearch = binding.recyclerViewBrowse
    }

    private fun initializeRecyclerView() {
        initializeLinearLayout()
        initializeAdapter()
        initializeListener()
    }

    private fun initializeLinearLayout() {
        artistsLinearLayoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        recyclerViewSearch.layoutManager = artistsLinearLayoutManager
    }

    private fun initializeAdapter() {
        artistAdapter = ArtistAdapter()
        recyclerViewSearch.adapter = artistAdapter
    }

    private fun initializeListener() {
        viewModel.getArtists().observe(viewLifecycleOwner) { tracksList ->
            artistAdapter.submitList(tracksList)
        }
        viewModel.getSearchedArtists("Blue")
    }
}
