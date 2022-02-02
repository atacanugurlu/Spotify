package com.atacanugurlu.spotify.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.databinding.MainFragmentBinding
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    private lateinit var binding : MainFragmentBinding
    private lateinit var signupButton : Button
    private lateinit var loginTextView : TextView
    private lateinit var googleButton : Button
    private lateinit var facebookButton : Button

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
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
    }

    private fun initializeBinding(inflater: LayoutInflater) {
        binding = MainFragmentBinding.inflate(inflater)
        bindVariables()
    }

    private fun bindVariables() {
        googleButton = binding.buttonGoogle
        facebookButton = binding.buttonFacebook
        loginTextView = binding.textViewLogin
        signupButton = binding.buttonSignup
    }

    private fun initializeNavigation() {
        signupButton.setOnClickListener(viewModel.navigateToSignUpPage())
        loginTextView.setOnClickListener(viewModel.navigateToLoginPage())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.instance.appComponent.inject(this)
    }
}