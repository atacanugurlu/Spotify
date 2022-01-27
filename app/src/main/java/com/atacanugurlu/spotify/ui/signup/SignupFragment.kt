package com.atacanugurlu.spotify.ui.signup

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.R
import com.atacanugurlu.spotify.databinding.MainFragmentBinding
import com.atacanugurlu.spotify.databinding.SignupFragmentBinding
import com.atacanugurlu.spotify.ui.main.MainViewModel
import javax.inject.Inject

class SignupFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    private lateinit var binding : SignupFragmentBinding

    private val viewModel: SignupViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[SignupViewModel::class.java]
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
        binding = SignupFragmentBinding.inflate(inflater)
    }

    private fun initializeNavigation() {
        binding.upButton.setOnClickListener(viewModel.navigateToMainPage())
    }

    private fun initializeUI() {
        binding.buttonNext.isEnabled = false
        binding.textViewSubmessage.text = getString(R.string.message)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.instance.appComponent.inject(this)
    }

}