package com.example.pix60

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.pix60.databinding.ImageItemBinding

class ImageAdapter : Adapter<ImageAdapter.ImageViewHolder>() {

    private val list = arrayListOf<ImageModel>()

    fun addImage(newList: List<ImageModel>)
    {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ImageItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ImageViewHolder(private var binding: ImageItemBinding): ViewHolder(binding.root)
    {
        fun bind(model: ImageModel){
            binding.ivImage.loadImage(model.largeImageUrl)
        }
    }
}