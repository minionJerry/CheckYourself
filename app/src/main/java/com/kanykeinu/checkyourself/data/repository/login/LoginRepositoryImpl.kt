package com.kanykeinu.checkyourself.data.repository.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.kanykeinu.checkyourself.data.entity.User
import com.kanykeinu.checkyourself.extensions.logError
import javax.inject.Inject

class LoginRepositoryImpl
@Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseFirestore: FirebaseFirestore)
    : LoginRepository
{

    companion object {
        const val COLLECTION_NAME = "USERS"
    }

    override fun firebaseSignInWithGoogle(googleAuthCredential: AuthCredential): LiveData<User> {
        val authenticatedUserMutableLiveData = MutableLiveData<User>()
        firebaseAuth.signInWithCredential(googleAuthCredential).addOnCompleteListener { authTask: Task<AuthResult> ->
            if (authTask.isSuccessful) {
                val isNewUser = authTask.result!!.additionalUserInfo!!.isNewUser
                val firebaseUser = firebaseAuth.currentUser
                if (firebaseUser != null) {
                    val uid = firebaseUser.uid
                    val name = firebaseUser.displayName
                    val email = firebaseUser.email
                    val user = User(uid, name!!, email!!)
                    user.isNew = isNewUser
                    authenticatedUserMutableLiveData.value = user
                }
            } else {
                authTask.exception?.logError()
            }
        }
        return authenticatedUserMutableLiveData
    }

    override fun createUserInFirestoreIfNotExists(authenticatedUser: User): LiveData<User>? {
        val usersRef = firebaseFirestore.collection(COLLECTION_NAME)
        val newUserMutableLiveData = MutableLiveData<User>()
        val uidRef: DocumentReference = usersRef.document(authenticatedUser.uid)
        uidRef.get().addOnCompleteListener { uidTask: Task<DocumentSnapshot?> ->
            if (uidTask.isSuccessful) {
                val document = uidTask.result
                if (!document!!.exists()) {
                    uidRef.set(authenticatedUser).addOnCompleteListener { userCreationTask: Task<Void?> ->
                        if (userCreationTask.isSuccessful) {
                            authenticatedUser.isCreated = true
                            newUserMutableLiveData.setValue(authenticatedUser)
                        } else {
                            userCreationTask.exception?.logError()
                        }
                    }
                } else {
                    newUserMutableLiveData.setValue(authenticatedUser)
                }
            } else {
                uidTask.exception?.logError()
            }
        }
        return newUserMutableLiveData
    }
}
