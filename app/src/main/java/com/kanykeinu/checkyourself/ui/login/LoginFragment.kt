package com.kanykeinu.checkyourself.ui.login

import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.GoogleAuthProvider
import com.kanykeinu.checkyourself.App
import com.kanykeinu.checkyourself.R
import com.kanykeinu.checkyourself.data.entity.User
import com.kanykeinu.checkyourself.extensions.logError
import com.kanykeinu.checkyourself.ui.splash.SplashViewModel
import kotlinx.android.synthetic.main.login_fragment.*
import javax.inject.Inject


class LoginFragment : Fragment() {

    companion object{
        private val RC_SIGN_IN: Int = 1234
    }

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: LoginViewModel
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    private fun injectComponent() {
        App.component()
            .loginComponentBuilder()
            .build()
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSignInButton()
        initGoogleSignInClient()
    }

    private fun initSignInButton() {
        btn_sign_in.setOnClickListener { signIn() }
    }

    private fun signIn() {
        val signInIntent: Intent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun initGoogleSignInClient() {
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), googleSignInOptions)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val googleSignInAccount: GoogleSignInAccount? = task.getResult(ApiException::class.java)
                googleSignInAccount?.let { getGoogleAuthCredential(it) }
            } catch (e: ApiException) {
                e.logError()
            }
        }
    }

    private fun getGoogleAuthCredential(googleSignInAccount: GoogleSignInAccount) {
        val googleTokenId = googleSignInAccount.idToken
        val googleAuthCredential = GoogleAuthProvider.getCredential(googleTokenId, null)
        signInWithGoogleAuthCredential(googleAuthCredential)
    }

    private fun signInWithGoogleAuthCredential(googleAuthCredential: AuthCredential) {
        viewModel.signInWithGoogle(googleAuthCredential)
        viewModel.authenticatedUserLiveData?.observe(this.viewLifecycleOwner, Observer {
            if (it.isNew) {
                createNewUser(it)
            } else {
                val text = "Welcome back, ${it.name}!"
                goToMainScreen(text)
            }
        })
    }

    private fun createNewUser(authenticatedUser : User){
        viewModel.createUser(authenticatedUser)
        viewModel.createdUserLiveData?.observe(this.viewLifecycleOwner, Observer {
            val userName = it.name
            var text = "Welcome $userName!"
            if (it.isCreated)
                text += "Lets begin our journey! Hope you will enjoy it!"
            goToMainScreen(text)
        })
    }

    private fun goToMainScreen(welcomeText: String) {
        val direction = LoginFragmentDirections.actionLoginFragmentToSubjectsFragment(welcomeText)
        Navigation.findNavController(this.requireView()).navigate(direction)
    }


}
