package com.atacanugurlu.spotify.ui.main

import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.atacanugurlu.spotify.R
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {

    fun navigateToSignUpPage() =
        Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_emailFragment)

    fun navigateToLoginPage() =
        Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_loginFragment)
}