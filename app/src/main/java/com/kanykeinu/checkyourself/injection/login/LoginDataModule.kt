package com.kanykeinu.checkyourself.injection.login

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.kanykeinu.checkyourself.data.repository.login.LoginRepository
import com.kanykeinu.checkyourself.data.repository.login.LoginRepositoryImpl
import com.kanykeinu.checkyourself.data.repository.splash.SplashRepository
import com.kanykeinu.checkyourself.data.repository.splash.SplashRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class LoginDataModule {
    @Binds
    internal abstract fun bindLoginRepository(
        repository: LoginRepositoryImpl
    ): LoginRepository

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