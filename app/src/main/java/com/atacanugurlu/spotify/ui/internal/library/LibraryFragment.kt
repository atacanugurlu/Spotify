package com.atacanugurlu.spotify.ui.internal.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.atacanugurlu.spotify.databinding.LibraryFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LibraryFragment : Fragment() {


    private lateinit var binding: LibraryFragmentBinding
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
        initializeNavigation()
    }

    private fun initializeBinding(inflater: LayoutInflater) {
        binding = LibraryFragmentBinding.inflate(inflater)
        bindVariables()
    }

    private fun bindVariables() {
    }

    private fun initializeNavigation() {
    }

}