package com.example.parsing_local_json_file

import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parsing_local_json_file.databinding.ItemRowBinding

class myAdapter(val Activity: MainActivity, val Images: ArrayList<Image>):RecyclerView.Adapter<myAdapter.ItemViewHolder>(){
    class ItemViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
// displaying the images in recycler view
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val listOfImage = Images[position]
        holder.binding.apply {
            Glide.with(Activity).load(listOfImage.Link).into(imgv)
        }
    }

    override fun getItemCount() = Images.size

}