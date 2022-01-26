package com.atacanugurlu.spotify.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atacanugurlu.spotify.ui.login.LoginViewModel
import com.atacanugurlu.spotify.ui.main.MainViewModel
import com.atacanugurlu.spotify.ui.signup.SignupViewModel
import com.atacanugurlu.spotify.util.factory.viewmodelfactory.ViewModelFactory
import com.atacanugurlu.spotify.util.factory.viewmodelfactory.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    protected abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    protected abstract fun loginViewModel(loginViewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignupViewModel::class)
    protected abstract fun signupViewModel(signupViewModel: SignupViewModel): ViewModel


}