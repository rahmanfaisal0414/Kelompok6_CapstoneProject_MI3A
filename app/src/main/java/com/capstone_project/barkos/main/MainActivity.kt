package com.capstone_project.barkos.main

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.capstone_project.barkos.R
import com.capstone_project.barkos.login.LoginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Use the correct layout XML

        // Initialize Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize views from layout
        val menuIcon = findViewById<ImageView>(R.id.menu_icon)
        val searchBar = findViewById<EditText>(R.id.search_bar)
        val heartIcon = findViewById<ImageView>(R.id.heart_icon)
        val chatIcon = findViewById<ImageView>(R.id.chat_icon)

        // Initialize Bottom Navigation
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Set up the Bottom Navigation Item Selection Listener
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_dashboard -> {
                    Toast.makeText(this, "Dashboard clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_notifications -> {
                    logout()
                    true
                }
                else -> false
            }
        }

        // Add actions for the menu icon
        menuIcon.setOnClickListener {
            Toast.makeText(this, "Menu icon clicked", Toast.LENGTH_SHORT).show()
            // Add your desired action here
        }

        // Add actions for the heart icon
        heartIcon.setOnClickListener {
            Toast.makeText(this, "Heart icon clicked", Toast.LENGTH_SHORT).show()
            // Add your desired action here
        }

        // Add actions for the chat icon
        chatIcon.setOnClickListener {
            Toast.makeText(this, "Chat icon clicked", Toast.LENGTH_SHORT).show()
            // Add your desired action here
        }

        // Action for typing in the search bar
        searchBar.setOnEditorActionListener { v, actionId, event ->
            val query = searchBar.text.toString()
            if (query.isNotEmpty()) {
                Toast.makeText(this, "Searching: $query", Toast.LENGTH_SHORT).show()
                // Add your search logic here
            }
            true
        }
    }

    // Function to handle logout
    private fun logout() {
        // Create an Intent to start LoginActivity
        val intent = Intent(this, LoginActivity::class.java) // Ensure you have a LoginActivity
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Clear the activity stack
        startActivity(intent)
        finish() // Optional: finish the current activity
    }
}
