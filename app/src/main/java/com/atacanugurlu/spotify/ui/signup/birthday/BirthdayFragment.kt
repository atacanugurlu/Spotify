package com.atacanugurlu.spotify.ui.signup.birthday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.atacanugurlu.spotify.databinding.BirthdayFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class BirthdayFragment : Fragment() {

    private lateinit var binding: BirthdayFragmentBinding
    private lateinit var upButton: ImageView
    private lateinit var datePicker: DatePicker
    private lateinit var nextButton: Button
    private val viewModel: BirthdayViewModel by viewModels()

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
        binding = BirthdayFragmentBinding.inflate(inflater)
        bindVariables()
    }

    private fun bindVariables() {
        upButton = binding.toolbar.upButton
        nextButton = binding.buttonBirthdayNext
        datePicker = binding.datePicker
    }

    private fun initializeNavigation() {
        upButton.setOnClickListener(viewModel.navigateToPasswordPage())
        nextButton.setOnClickListener(viewModel.navigateToGenderPage())
    }

    private fun initializeUI() {
        setMaximumDate()
        nextButton.isEnabled = true
    }

    private fun setMaximumDate() {
        datePicker.maxDate = Date().time
    }
}
