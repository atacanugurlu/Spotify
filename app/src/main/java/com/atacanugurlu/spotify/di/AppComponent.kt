package com.atacanugurlu.spotify.di

import com.atacanugurlu.spotify.MainApp
import com.atacanugurlu.spotify.ui.login.LoginFragment
import com.atacanugurlu.spotify.ui.main.MainFragment
import com.atacanugurlu.spotify.ui.signup.SignupFragment
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
    fun inject(signupFragment: SignupFragment)
}