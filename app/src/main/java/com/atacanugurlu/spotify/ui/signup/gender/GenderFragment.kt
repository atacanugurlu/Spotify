package com.atacanugurlu.spotify.ui.signup.gender

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.databinding.GenderFragmentBinding
import javax.inject.Inject

class GenderFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    private lateinit var binding : GenderFragmentBinding

    private val viewModel: GenderViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[GenderViewModel::class.java]
    }

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
        initializeUI()
    }

    private fun initializeBinding(inflater: LayoutInflater) {
        binding = GenderFragmentBinding.inflate(inflater)
    }

    private fun initializeNavigation() {
        binding.toolbar.upButton.setOnClickListener(viewModel.navigateToBirthdayPage())
    }

    private fun initializeUI() {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.instance.appComponent.inject(this)
    }

}