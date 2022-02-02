package com.atacanugurlu.spotify.ui.signup.email

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.R
import com.atacanugurlu.spotify.databinding.EmailFragmentBinding
import com.google.android.material.textfield.TextInputEditText
import javax.inject.Inject

class EmailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    private lateinit var binding : EmailFragmentBinding
    private lateinit var upButton : ImageView
    private lateinit var nextButton : Button
    private lateinit var editTextEmail: TextInputEditText
    private lateinit var textViewSubMessage: TextView

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.instance.appComponent.inject(this)
    }

}