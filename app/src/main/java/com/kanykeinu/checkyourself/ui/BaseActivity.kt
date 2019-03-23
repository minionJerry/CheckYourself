package com.kanykeinu.checkyourself.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract val appbarTitle : String?

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (appbarTitle!=null) {
            supportActionBar?.show()
            supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = appbarTitle
        } else supportActionBar?.hide()
    }
}