package com.atacanugurlu.spotify.ui.signup.email

import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.atacanugurlu.spotify.R
import javax.inject.Inject

class EmailViewModel @Inject constructor() : ViewModel() {

    fun navigateToMainPage() =
        Navigation.createNavigateOnClickListener(R.id.action_emailFragment_to_mainFragment)

    fun navigateToPasswordPage() =
        Navigation.createNavigateOnClickListener(R.id.action_emailFragment_to_passwordFragment)
}