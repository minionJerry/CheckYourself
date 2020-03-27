package com.kanykeinu.checkyourself.data.repository.splash

import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.kanykeinu.checkyourself.data.entity.User
import com.kanykeinu.checkyourself.data.repository.login.LoginRepositoryImpl
import com.kanykeinu.checkyourself.extensions.logError
import javax.inject.Inject


class SplashRepositoryImpl
@Inject constructor(private val firebaseAuth: FirebaseAuth, private val firebaseFirestore: FirebaseFirestore)
    : SplashRepository {

    override fun checkIfUserIsAuthenticatedInFirebase(): MutableLiveData<User>? {
        val user: User = User()
        val isUserAuthenticateInFirebaseMutableLiveData = MutableLiveData<User>()
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            user.isAuthenticated = false
            isUserAuthenticateInFirebaseMutableLiveData.setValue(user)
        } else {
            user.uid = firebaseUser.uid
            user.isAuthenticated = true
            isUserAuthenticateInFirebaseMutableLiveData.setValue(user)
        }
        return isUserAuthenticateInFirebaseMutableLiveData
    }

    override fun addUserToLiveData(uid: String?): MutableLiveData<User>? {
        val usersRef = firebaseFirestore.collection(LoginRepositoryImpl.COLLECTION_NAME)
        val userMutableLiveData = MutableLiveData<User>()
        usersRef.document(uid!!).get().addOnCompleteListener { userTask: Task<DocumentSnapshot?> ->
            if (userTask.isSuccessful) {
                val document = userTask.result
                if (document != null && document.exists()) {
                    val user = document.toObject(User::class.java)
                    userMutableLiveData.value = user
                }
            } else {
                userTask.exception?.logError()
            }
        }
        return userMutableLiveData
    }

}
