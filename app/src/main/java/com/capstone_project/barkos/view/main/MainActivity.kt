package com.capstone_project.barkos.view.main

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.capstone_project.barkos.R
import com.capstone_project.barkos.view.Home.HomeFragment
import com.capstone_project.barkos.view.account.AccountFragment
import com.capstone_project.barkos.view.add.AddFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)

        // Initialize Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize views
        val menuIcon = findViewById<ImageView>(R.id.menu_icon)
        val searchBar = findViewById<EditText>(R.id.search_bar)
        val heartIcon = findViewById<ImageView>(R.id.heart_icon)
        val chatIcon = findViewById<ImageView>(R.id.chat_icon)

        // Initialize Bottom Navigation
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Load HomeFragment by default
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        // Handle Bottom Navigation Item Selection
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_add -> {
                    loadFragment(AddFragment())
                    true
                }
                R.id.nav_pengguna -> {
                    loadFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }

        // Actions for icons in toolbar
        menuIcon.setOnClickListener {
            Toast.makeText(this, "Menu icon clicked", Toast.LENGTH_SHORT).show()
        }

        heartIcon.setOnClickListener {
            Toast.makeText(this, "Heart icon clicked", Toast.LENGTH_SHORT).show()
        }

        chatIcon.setOnClickListener {
            Toast.makeText(this, "Chat icon clicked", Toast.LENGTH_SHORT).show()
        }

        searchBar.setOnEditorActionListener { v, actionId, event ->
            val query = searchBar.text.toString()
            if (query.isNotEmpty()) {
                Toast.makeText(this, "Searching: $query", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    // Function to replace the fragment in fragment_container
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
