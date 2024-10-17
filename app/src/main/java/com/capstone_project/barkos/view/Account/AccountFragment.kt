package com.capstone_project.barkos.view.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.capstone_project.barkos.R
import com.capstone_project.barkos.view.login.LoginActivity  // Import your LoginActivity

class AccountFragment : Fragment() {

    private lateinit var textViewFullName: TextView
    private lateinit var textViewEmail: TextView
    private lateinit var textViewPassword: TextView
    private lateinit var buttonLogout: Button

    // Hard-coded user data for testing purposes
    private val userFullName = "John Doe"
    private val userEmail = "johndoe@example.com"
    private val userPassword = "password123"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account, container, false)

        // Initialize views
        textViewFullName = view.findViewById(R.id.textViewFullName)
        textViewEmail = view.findViewById(R.id.textViewEmail)
        textViewPassword = view.findViewById(R.id.textViewPassword)
        buttonLogout = view.findViewById(R.id.buttonLogout)

        // Load user data
        loadUserData()

        // Set up logout button listener
        buttonLogout.setOnClickListener {
            logoutUser()
        }

        return view
    }

    private fun loadUserData() {
        // Set the TextViews with hard-coded user data
        textViewFullName.text = userFullName
        textViewEmail.text = userEmail
        textViewPassword.text = userPassword
    }

    private fun logoutUser() {
        // Create an Intent to navigate to LoginActivity
        val intent = Intent(requireActivity(), LoginActivity::class.java)
        // Optionally, clear any user data or session information here

        // Finish the current activity (optional)
        startActivity(intent)
        requireActivity().finish()  // Finish the current fragment's activity
    }
}
