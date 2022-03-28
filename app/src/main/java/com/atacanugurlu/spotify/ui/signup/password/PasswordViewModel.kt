package com.atacanugurlu.spotify.ui.signup.password

import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.atacanugurlu.spotify.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PasswordViewModel @Inject constructor() : ViewModel() {
    fun navigateToSignupPage() =
        Navigation.createNavigateOnClickListener(R.id.action_passwordFragment_to_emailFragment)

    fun navigateToBirthdayPage() =
        Navigation.createNavigateOnClickListener(R.id.action_passwordFragment_to_birthdayFragment)
}
