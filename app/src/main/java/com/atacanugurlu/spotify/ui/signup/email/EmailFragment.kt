package com.atacanugurlu.spotify.ui.signup.email

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.R
import com.atacanugurlu.spotify.databinding.EmailFragmentBinding
import javax.inject.Inject

class EmailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    private lateinit var binding : EmailFragmentBinding

    private val viewModel: EmailViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[EmailViewModel::class.java]
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
        binding = EmailFragmentBinding.inflate(inflater)
    }

    private fun initializeNavigation() {
        binding.toolbar.upButton.setOnClickListener(viewModel.navigateToMainPage())
        binding.buttonNext.setOnClickListener(viewModel.navigateToPasswordPage())
    }

    private fun initializeUI() {
        binding.buttonNext.isEnabled = true
        binding.textViewSubmessage.text = getString(R.string.message)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.instance.appComponent.inject(this)
    }

}