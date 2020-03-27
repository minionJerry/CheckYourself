package com.kanykeinu.checkyourself.injection.splash

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.kanykeinu.checkyourself.data.repository.splash.SplashRepository
import com.kanykeinu.checkyourself.data.repository.splash.SplashRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class SplashDataModule {
    @Binds
    internal abstract fun bindSplashRepository(
        repository: SplashRepositoryImpl
    ): SplashRepository

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideFirebaseAuth(): FirebaseAuth =
            FirebaseAuth.getInstance()

        @JvmStatic
        @Provides
        fun provideFirebaseFirestore(): FirebaseFirestore =
            FirebaseFirestore.getInstance()
    }
}