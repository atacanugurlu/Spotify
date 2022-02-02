package com.atacanugurlu.spotify.ui.login

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.databinding.LoginFragmentBinding
import com.google.android.material.textfield.TextInputEditText
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: LoginFragmentBinding
    private lateinit var upButton : ImageView
    private lateinit var editTextUsername : TextInputEditText
    private lateinit var editTextPassword : TextInputEditText
    private lateinit var loginButton : Button
    private lateinit var loginWithoutPasswordButton : Button

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]
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
        binding = LoginFragmentBinding.inflate(inflater)
        bindVariables()
    }

    private fun bindVariables() {
        upButton = binding.toolbar.upButton
        loginButton = binding.buttonLogin
        editTextUsername = binding.editTextEmailOrUsername
        editTextPassword = binding.editTextPassword
        loginWithoutPasswordButton = binding.loginWithoutPasswordButton
    }

    private fun initializeNavigation() {
        upButton.setOnClickListener(viewModel.navigateToMainPage())
        loginButton.setOnClickListener(viewModel.navigateToHomePage())
    }

    private fun initializeUI() {
        loginButton.isEnabled = true
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.instance.appComponent.inject(this)
    }

}