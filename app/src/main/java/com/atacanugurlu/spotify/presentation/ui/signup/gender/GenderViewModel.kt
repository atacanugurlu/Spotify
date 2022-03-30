package com.atacanugurlu.spotify.presentation.ui.signup.gender

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.atacanugurlu.spotify.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenderViewModel@Inject constructor() : ViewModel() {

    private var gender: String = ""

    fun navigateToBirthdayPage() =
        Navigation.createNavigateOnClickListener(R.id.action_genderFragment_to_birthdayFragment)

    fun setMaleAndNavigate(): View.OnClickListener {
        gender = "male"
        return navigateToNamePage()
    }

    fun setFemaleAndNavigate(): View.OnClickListener {
        gender = "female"
        return navigateToNamePage()
    }

    fun setNonBinaryAndNavigate(): View.OnClickListener {
        gender = "non-binary"
        return navigateToNamePage()
    }

    private fun navigateToNamePage() =
        Navigation.createNavigateOnClickListener(R.id.action_genderFragment_to_nameFragment)
}
