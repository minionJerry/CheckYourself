package com.kanykeinu.checkyourself.ui

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kanykeinu.checkyourself.R
import com.kanykeinu.checkyourself.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main_host.*

class MainHostActivity : BaseActivity() {

    override val appbarTitle: String?
        get() = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_host)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.fragment_container)
//        setupActionBarWithNavController(navController)
        navigation.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragment_container).navigateUp()
    }
}
