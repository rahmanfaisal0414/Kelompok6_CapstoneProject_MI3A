package com.capstone_project.barkos.view.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.capstone_project.barkos.R

class ImageSliderAdapter(private val items: List<Item>) : RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder>() {

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_slider, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull holder: ImageViewHolder, position: Int) {
        // Use the image resource ID from the Item object
        holder.imageView.setImageResource(items[position].imageResId)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
