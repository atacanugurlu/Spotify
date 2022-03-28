package com.atacanugurlu.spotify.ui.signup.name

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.atacanugurlu.spotify.databinding.NameFragmentBinding
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NameFragment : Fragment() {

    private lateinit var binding: NameFragmentBinding
    private lateinit var upButton: ImageView
    private lateinit var createAccountButton: Button
    private lateinit var editTextName: TextInputEditText
    private lateinit var textViewTermsOfUse: TextView
    private lateinit var textViewPrivacyPolicy: TextView
    private lateinit var marketingRadioButton: RadioButton
    private lateinit var shareRadioButton: RadioButton
    private val viewModel: NameViewModel by viewModels()

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
        binding = NameFragmentBinding.inflate(inflater)
        bindVariables()
    }

    private fun bindVariables() {
        upButton = binding.toolbar.upButton
        createAccountButton = binding.buttonCreateAccount
        editTextName = binding.editTextName
        textViewTermsOfUse = binding.textViewTermsOfUseLink
        textViewPrivacyPolicy = binding.textViewPrivacyPolicyLink
        marketingRadioButton = binding.radioMarketingMessage
        shareRadioButton = binding.radioShareMessage
    }

    private fun initializeNavigation() {
        upButton.setOnClickListener(viewModel.navigateToGenderPage())
        createAccountButton.setOnClickListener(viewModel.navigateToLoginPage())
    }

}
