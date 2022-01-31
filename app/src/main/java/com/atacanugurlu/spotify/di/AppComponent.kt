package com.atacanugurlu.spotify.di

import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.ui.internal.home.HomeFragment
import com.atacanugurlu.spotify.ui.internal.library.LibraryFragment
import com.atacanugurlu.spotify.ui.internal.search.SearchFragment
import com.atacanugurlu.spotify.ui.login.LoginFragment
import com.atacanugurlu.spotify.ui.main.MainFragment
import com.atacanugurlu.spotify.ui.signup.birthday.BirthdayFragment
import com.atacanugurlu.spotify.ui.signup.password.PasswordFragment
import com.atacanugurlu.spotify.ui.signup.email.EmailFragment
import com.atacanugurlu.spotify.ui.signup.gender.GenderFragment
import com.atacanugurlu.spotify.ui.signup.name.NameFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        ViewModelModule::class
    ]
)

interface AppComponent {
    fun inject(application: MainApp)
    fun inject(loginFragment : LoginFragment)
    fun inject(mainFragment: MainFragment)
    fun inject(emailFragment: EmailFragment)
    fun inject(passwordFragment: PasswordFragment)
    fun inject(birthdayFragment: BirthdayFragment)
    fun inject(genderFragment : GenderFragment)
    fun inject(nameFragment : NameFragment)
    fun inject(homeFragment : HomeFragment)
    fun inject(searchFragment : SearchFragment)
    fun inject(libraryFragment : LibraryFragment)
}