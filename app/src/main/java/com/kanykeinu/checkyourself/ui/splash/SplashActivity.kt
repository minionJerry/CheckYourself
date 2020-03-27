package com.kanykeinu.checkyourself.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kanykeinu.checkyourself.App
import com.kanykeinu.checkyourself.R
import com.kanykeinu.checkyourself.data.entity.User
import com.kanykeinu.checkyourself.ui.MainHostActivity
import javax.inject.Inject


class SplashActivity : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        injectComponent()
        splashViewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel::class.java)
        checkIfUserIsAuthenticated()
    }

    private fun injectComponent() {
        App.component()
            .splashComponentBuilder()
            .build()
            .inject(this)
    }

    private fun checkIfUserIsAuthenticated() {
        splashViewModel.checkIfUserIsAuthenticated()
        splashViewModel.isUserAuthenticatedLiveData?.observe(this, Observer {
            if (!it.isAuthenticated)
                goToMainScreen()
            else getUserFromDatabase(it.uid)
        })
    }

    private fun getUserFromDatabase(uid: String) {
        splashViewModel.setUid(uid)
        splashViewModel.userLiveData!!.observe(this, Observer { user: User ->
            goToMainScreen()
        })
    }

    private fun goToMainScreen() {
        val intent = Intent(this, MainHostActivity::class.java)
        startActivity(intent)
        finish()
    }


}
