package com.kanykeinu.checkyourself

import android.app.Application
import com.google.firebase.FirebaseApp
import com.kanykeinu.checkyourself.injection.common.AppComponent
import com.kanykeinu.checkyourself.injection.common.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var application: App
            private set

        fun component(): AppComponent =
            application.component
    }

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        application = this

        FirebaseApp.initializeApp(application)
        component = DaggerAppComponent.builder()
            .context(application)
            .build()
    }
}