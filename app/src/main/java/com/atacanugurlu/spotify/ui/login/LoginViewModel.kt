package com.atacanugurlu.spotify.ui.login

import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.atacanugurlu.spotify.R
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {
    fun navigateToMainPage() =
        Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_mainFragment)
}