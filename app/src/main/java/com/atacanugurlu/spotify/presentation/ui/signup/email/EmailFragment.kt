package com.atacanugurlu.spotify.presentation.ui.signup.email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.atacanugurlu.spotify.R
import com.atacanugurlu.spotify.databinding.EmailFragmentBinding
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmailFragment : Fragment() {

    private lateinit var binding: EmailFragmentBinding
    private lateinit var upButton: ImageView
    private lateinit var nextButton: Button
    private lateinit var editTextEmail: TextInputEditText
    private lateinit var textViewSubMessage: TextView
    private val viewModel: EmailViewModel by viewModels()

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
        initializeUI()
    }

    private fun initializeBinding(inflater: LayoutInflater) {
        binding = EmailFragmentBinding.inflate(inflater)
        bindVariables()
    }

    private fun bindVariables() {
        upButton = binding.toolbar.upButton
        nextButton = binding.buttonNext
        editTextEmail = binding.editTextEmail
        textViewSubMessage = binding.textViewSubmessage
    }

    private fun initializeNavigation() {
        upButton.setOnClickListener(viewModel.navigateToMainPage())
        nextButton.setOnClickListener(viewModel.navigateToPasswordPage())
    }

    private fun initializeUI() {
        nextButton.isEnabled = true
        textViewSubMessage.text = getString(R.string.message)
    }
}
