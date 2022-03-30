package com.atacanugurlu.spotify.presentation.ui.login

import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.atacanugurlu.spotify.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    fun navigateToMainPage() =
        Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_mainFragment)

    fun navigateToHomePage() =
        Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_homeFragment)
}
