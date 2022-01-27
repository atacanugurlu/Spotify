package com.atacanugurlu.spotify.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atacanugurlu.spotify.ui.login.LoginViewModel
import com.atacanugurlu.spotify.ui.main.MainViewModel
import com.atacanugurlu.spotify.ui.signup.birthday.BirthdayViewModel
import com.atacanugurlu.spotify.ui.signup.password.PasswordViewModel
import com.atacanugurlu.spotify.ui.signup.email.EmailViewModel
import com.atacanugurlu.spotify.ui.signup.gender.GenderViewModel
import com.atacanugurlu.spotify.ui.signup.name.NameViewModel
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
    @ViewModelKey(EmailViewModel::class)
    protected abstract fun emailViewModel(emailViewModel: EmailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PasswordViewModel::class)
    protected abstract fun passwordViewModel(passwordViewModel: PasswordViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BirthdayViewModel::class)
    protected abstract fun birthdayViewModel(birthdayViewModel: BirthdayViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GenderViewModel::class)
    protected abstract fun genderViewModel(genderViewModel: GenderViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NameViewModel::class)
    protected abstract fun nameViewModel(nameViewModel: NameViewModel): ViewModel


}