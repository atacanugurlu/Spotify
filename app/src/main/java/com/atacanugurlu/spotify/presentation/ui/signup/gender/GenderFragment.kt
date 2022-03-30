package com.atacanugurlu.spotify.presentation.ui.signup.gender

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.atacanugurlu.spotify.databinding.GenderFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenderFragment : Fragment() {

    private lateinit var binding: GenderFragmentBinding
    private lateinit var upButton: ImageView
    private lateinit var maleButton: Button
    private lateinit var femaleButton: Button
    private lateinit var nonBinaryButton: Button
    private val viewModel: GenderViewModel by viewModels()

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
        initializeNavigation()
    }

    private fun initializeBinding(inflater: LayoutInflater) {
        binding = GenderFragmentBinding.inflate(inflater)
        bindVariables()
    }

    private fun bindVariables() {
        upButton = binding.toolbar.upButton
        maleButton = binding.maleButton
        femaleButton = binding.femaleButton
        nonBinaryButton = binding.nonBinaryButton
    }

    private fun initializeNavigation() {
        upButton.setOnClickListener(viewModel.navigateToBirthdayPage())
        maleButton.setOnClickListener(viewModel.setMaleAndNavigate())
        femaleButton.setOnClickListener(viewModel.setFemaleAndNavigate())
        nonBinaryButton.setOnClickListener(viewModel.setNonBinaryAndNavigate())
    }
}
