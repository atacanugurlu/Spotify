package com.atacanugurlu.spotify.ui.signup.password

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.R
import com.atacanugurlu.spotify.databinding.PasswordFragmentBinding
import javax.inject.Inject

class PasswordFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    private lateinit var binding : PasswordFragmentBinding

    private val viewModel: PasswordViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[PasswordViewModel::class.java]
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
        binding = PasswordFragmentBinding.inflate(inflater)
    }

    private fun initializeNavigation() {
        binding.toolbar.upButton.setOnClickListener(viewModel.navigateToSignupPage())
        binding.buttonPasswordNext.setOnClickListener(viewModel.navigateToBirthdayPage())
    }

    private fun initializeUI() {
        binding.buttonPasswordNext.isEnabled = true
        binding.textViewPasswordMessage.text = getString(R.string.password_message)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.instance.appComponent.inject(this)
    }

}