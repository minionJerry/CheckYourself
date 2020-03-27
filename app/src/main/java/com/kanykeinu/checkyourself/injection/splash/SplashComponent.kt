package com.kanykeinu.checkyourself.injection.splash

import com.kanykeinu.checkyourself.ui.splash.SplashActivity
import dagger.Subcomponent

@Subcomponent(modules = [SplashModule::class, SplashDataModule::class])
interface SplashComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): SplashComponent
    }

    fun inject(splashActivity: SplashActivity)
}