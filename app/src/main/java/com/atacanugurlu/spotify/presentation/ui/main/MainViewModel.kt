package com.atacanugurlu.spotify.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.atacanugurlu.spotify.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    fun navigateToSignUpPage() =
        Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_emailFragment)

    fun navigateToLoginPage() =
        Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_loginFragment)
}
