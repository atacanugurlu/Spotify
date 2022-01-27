package com.atacanugurlu.spotify.ui.signup

import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.atacanugurlu.spotify.R
import javax.inject.Inject

class SignupViewModel @Inject constructor() : ViewModel() {
    fun navigateToMainPage() =
        Navigation.createNavigateOnClickListener(R.id.action_signupFragment_to_mainFragment)
}