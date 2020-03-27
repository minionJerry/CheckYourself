package com.kanykeinu.checkyourself.injection.splash

import androidx.lifecycle.ViewModel
import com.kanykeinu.checkyourself.injection.common.ViewModelKey
import com.kanykeinu.checkyourself.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun bindSplashViewModel(viewModel: SplashViewModel) : ViewModel
}