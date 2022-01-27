package com.atacanugurlu.spotify.ui.signup.name

import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.atacanugurlu.spotify.R
import javax.inject.Inject

class NameViewModel @Inject constructor(): ViewModel() {

    fun navigateToGenderPage() =
        Navigation.createNavigateOnClickListener(R.id.action_nameFragment_to_genderFragment)
}