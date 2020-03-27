package com.kanykeinu.checkyourself.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kanykeinu.checkyourself.data.entity.User
import com.kanykeinu.checkyourself.data.repository.splash.SplashRepositoryImpl
import javax.inject.Inject


class SplashViewModel
@Inject constructor(
    private val splashRepository: SplashRepositoryImpl
) : ViewModel() {

    var isUserAuthenticatedLiveData: LiveData<User>? = null
    var userLiveData: LiveData<User>? = null

    fun checkIfUserIsAuthenticated() {
        isUserAuthenticatedLiveData = splashRepository.checkIfUserIsAuthenticatedInFirebase();
    }

    fun setUid(uid: String?) {
        userLiveData = splashRepository.addUserToLiveData(uid)
    }
}