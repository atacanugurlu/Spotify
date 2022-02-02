package com.atacanugurlu.spotify.ui.signup.birthday

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.databinding.BirthdayFragmentBinding
import java.util.*
import javax.inject.Inject

class BirthdayFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: BirthdayFragmentBinding
    private lateinit var upButton : ImageView
    private lateinit var datePicker : DatePicker
    private lateinit var nextButton : Button

    private val viewModel: BirthdayViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[BirthdayViewModel::class.java]
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApp.instance.appComponent.inject(this)
    }

}