package com.kanykeinu.checkyourself.data.repository.splash

import androidx.lifecycle.MutableLiveData
import com.kanykeinu.checkyourself.data.entity.User

interface SplashRepository {
    fun checkIfUserIsAuthenticatedInFirebase(): MutableLiveData<User>?
    fun addUserToLiveData(uid: String?): MutableLiveData<User>?
}