package com.atacanugurlu.spotify.ui.signup.gender

import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.atacanugurlu.spotify.R
import javax.inject.Inject

class GenderViewModel@Inject constructor() : ViewModel() {

    fun navigateToBirthdayPage() =
        Navigation.createNavigateOnClickListener(R.id.action_genderFragment_to_birthdayFragment)
/*
    fun navigateToPasswordPage() =
        Navigation.createNavigateOnClickListener(R.id.action_emailFragment_to_passwordFragment)

 */
}