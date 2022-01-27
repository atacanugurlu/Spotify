package com.atacanugurlu.spotify.ui.signup.birthday

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.databinding.BirthdayFragmentBinding
import javax.inject.Inject

class BirthdayFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    private lateinit var binding : BirthdayFragmentBinding

    private val viewModel: BirthdayViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[BirthdayViewModel::class.java]
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
        binding = BirthdayFragmentBinding.inflate(inflater)
    }

    private fun initializeNavigation() {
        binding.toolbar.upButton.setOnClickListener(viewModel.navigateToPasswordPage())
        binding.buttonBirthdayNext.setOnClickListener(viewModel.navigateToGenderPage())
    }

    private fun initializeUI() {
        binding.buttonBirthdayNext.isEnabled = true

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.instance.appComponent.inject(this)
    }

}