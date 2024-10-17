package com.capstone_project.barkos.view.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.capstone_project.barkos.R
import com.capstone_project.barkos.view.Home.Item

class AddFragment : Fragment() {

    private lateinit var editTextTitle: EditText
    private lateinit var editTextPrice: EditText
    private lateinit var editTextSeller: EditText
    private lateinit var imageViewPlaceholder: ImageView
    private lateinit var buttonAddItem: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        // Initialize views
        editTextTitle = view.findViewById(R.id.editTextTitle)
        editTextPrice = view.findViewById(R.id.editTextPrice)
        editTextSeller = view.findViewById(R.id.editTextCondition)
        imageViewPlaceholder = view.findViewById(R.id.imageViewPlaceholder)
        buttonAddItem = view.findViewById(R.id.buttonAddItem)

        // Set up button click listener
        buttonAddItem.setOnClickListener {
            addItem()
        }

        return view
    }

    private fun addItem() {
        val title = editTextTitle.text.toString()
        val price = editTextPrice.text.toString()
        val seller = editTextSeller.text.toString()

        // Validate input
        if (title.isEmpty() || price.isEmpty() || seller.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Create the new item
        val newItem = Item(imageResId = R.drawable.placeholder_image, title, price, seller)

        // For demonstration, show a toast message
        Toast.makeText(requireContext(), "Item Added: $title", Toast.LENGTH_SHORT).show()

        // Reset the fields
        editTextTitle.text.clear()
        editTextPrice.text.clear()
        editTextSeller.text.clear()
    }
}
