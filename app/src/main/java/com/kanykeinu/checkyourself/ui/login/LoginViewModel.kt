package com.kanykeinu.checkyourself.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.AuthCredential
import com.kanykeinu.checkyourself.data.entity.User
import com.kanykeinu.checkyourself.data.repository.login.LoginRepositoryImpl
import javax.inject.Inject


class LoginViewModel
@Inject constructor(
    private val loginRepository: LoginRepositoryImpl
) : ViewModel() {

    var createdUserLiveData: LiveData<User>? = null
    var authenticatedUserLiveData: LiveData<User>? = null


    fun signInWithGoogle(googleAuthCredential: AuthCredential) {
        authenticatedUserLiveData = loginRepository.firebaseSignInWithGoogle(googleAuthCredential)
    }

    fun createUser(authenticatedUser: User) {
        createdUserLiveData = loginRepository.createUserInFirestoreIfNotExists(authenticatedUser)
    }
}
