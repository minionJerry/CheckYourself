package com.kanykeinu.checkyourself.injection.login

import com.kanykeinu.checkyourself.ui.login.LoginFragment
import com.kanykeinu.checkyourself.ui.splash.SplashActivity
import dagger.Subcomponent

@Subcomponent(modules = [LoginModule::class, LoginDataModule::class])
interface LoginComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): LoginComponent
    }

    fun inject(loginFragment: LoginFragment)
}