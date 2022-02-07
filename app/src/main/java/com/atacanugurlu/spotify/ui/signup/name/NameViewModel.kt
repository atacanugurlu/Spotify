package com.atacanugurlu.spotify.ui.signup.name

import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.atacanugurlu.spotify.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NameViewModel @Inject constructor(): ViewModel() {

    fun navigateToGenderPage() =
        Navigation.createNavigateOnClickListener(R.id.action_nameFragment_to_genderFragment)

    fun navigateToLoginPage() =
        Navigation.createNavigateOnClickListener(R.id.action_nameFragment_to_loginFragment)
}