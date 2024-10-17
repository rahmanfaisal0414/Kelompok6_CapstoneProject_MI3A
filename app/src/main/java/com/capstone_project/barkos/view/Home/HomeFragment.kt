package com.capstone_project.barkos.view.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.capstone_project.barkos.R

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var imageSliderAdapter: ImageSliderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize ViewPager2 for the image slider
        viewPager = view.findViewById(R.id.viewPager)

        // Example item list for image slider
        val imageList = listOf(
            Item(R.drawable.banner_1, "0", "1", "1"),
            Item(R.drawable.banner_2, "1", "1", "1")
        )

        // Set up the image slider adapter
        imageSliderAdapter = ImageSliderAdapter(imageList)
        viewPager.adapter = imageSliderAdapter

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2) // 2 columns for grid

        // Set up the item adapter for RecyclerView
        val itemList = listOf(
            Item(R.drawable.kemeja_bekas, "Kemeja Bekas", "Rp. 20.000", "Ahmad"),
            Item(R.drawable.ransel_bekas, "Ransel Bekas", "Rp. 50.000", "Budi"),
            Item(R.drawable.meja_bekas, "Meja Bekas", "Rp. 100.000", "Citra"),
            Item(R.drawable.coocker_bekas, "Coocker Bekas", "Rp. 75.000", "Dewi"),
            Item(R.drawable.gantungan_bekas, "Gantungan Bekas", "Rp. 15.000", "Eka"),
            Item(R.drawable.kursi_bekas, "Kursi Bekas", "Rp. 30.000", "Faisal")
        )

        // Set up the adapter for RecyclerView
        itemAdapter = ItemAdapter(itemList)
        recyclerView.adapter = itemAdapter

        return view
    }
}

