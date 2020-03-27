package com.kanykeinu.checkyourself.injection.common

import android.content.Context
import com.kanykeinu.checkyourself.injection.login.LoginComponent
import com.kanykeinu.checkyourself.injection.splash.SplashComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun splashComponentBuilder(): SplashComponent.Builder

    fun loginComponentBuilder(): LoginComponent.Builder
}