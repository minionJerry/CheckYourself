package com.kanykeinu.checkyourself.data.repository.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.AuthCredential
import com.kanykeinu.checkyourself.data.entity.User

interface LoginRepository {
    fun firebaseSignInWithGoogle(googleAuthCredential: AuthCredential): LiveData<User>
    fun createUserInFirestoreIfNotExists(authenticatedUser: User): LiveData<User>?
}