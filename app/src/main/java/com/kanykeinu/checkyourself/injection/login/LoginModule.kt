package com.kanykeinu.checkyourself.injection.login

import androidx.lifecycle.ViewModel
import com.kanykeinu.checkyourself.injection.common.ViewModelKey
import com.kanykeinu.checkyourself.ui.login.LoginViewModel
import com.kanykeinu.checkyourself.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindLoginViewModel(viewModel: LoginViewModel) : ViewModel
}