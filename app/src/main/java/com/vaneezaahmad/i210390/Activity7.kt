package com.vaneezaahmad.i210390

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class Activity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_7)

        val fragment1 = Home_fragment()
        val fragment2 = Search_fragment()
        val fragment3 = Chat_fragment()
        val fragment4 = Profile_fragment()

        setCurrentFragment(fragment1)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> setCurrentFragment(fragment1)
                R.id.navigation_search -> setCurrentFragment(fragment2)
                R.id.navigation_chats -> setCurrentFragment(fragment3)
                R.id.navigation_profile -> setCurrentFragment(fragment4)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container_view, fragment)
            commit()
        }
}