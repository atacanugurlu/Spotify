package com.atacanugurlu.spotify.ui.signup.password

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.R
import com.atacanugurlu.spotify.databinding.PasswordFragmentBinding
import com.google.android.material.textfield.TextInputEditText
import javax.inject.Inject

class PasswordFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    private lateinit var binding : PasswordFragmentBinding
    private lateinit var upButton : ImageView
    private lateinit var nextButton : Button
    private lateinit var editTextPassword: TextInputEditText
    private lateinit var passwordMessageTextView: TextView

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
        bindVariables()
    }

    private fun bindVariables() {
        upButton = binding.toolbar.upButton
        nextButton = binding.buttonPasswordNext
        editTextPassword = binding.editTextPassword
        passwordMessageTextView = binding.textViewPasswordMessage
    }

    private fun initializeNavigation() {
        upButton.setOnClickListener(viewModel.navigateToSignupPage())
        nextButton.setOnClickListener(viewModel.navigateToBirthdayPage())
    }

    private fun initializeUI() {
        nextButton.isEnabled = true
        passwordMessageTextView.text = getString(R.string.password_message)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.instance.appComponent.inject(this)
    }

}