package com.kanykeinu.checkyourself.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.kanykeinu.checkyourself.R
import com.kanykeinu.checkyourself.ui.subjectsList.SubjectListFragment
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
