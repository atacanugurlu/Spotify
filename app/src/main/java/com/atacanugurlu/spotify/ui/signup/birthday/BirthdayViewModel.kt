package com.atacanugurlu.spotify.ui.signup.birthday

import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.atacanugurlu.spotify.R
import javax.inject.Inject

class BirthdayViewModel @Inject constructor(): ViewModel() {

    fun navigateToPasswordPage() =
        Navigation.createNavigateOnClickListener(R.id.action_birthdayFragment_to_passwordFragment)

    fun navigateToGenderPage() =
        Navigation.createNavigateOnClickListener(R.id.action_birthdayFragment_to_genderFragment)
}