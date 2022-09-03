package com.example.g10consultancyassignmentapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.g10consultancyassignmentapp.databinding.ImageViewBinding

class ViewPagerRecyclerAdapter(
    private val imagesArray: List<String>,
    private val context: Context
): RecyclerView.Adapter<ViewPagerRecyclerAdapter.MyViewHolder> (){

    class  MyViewHolder(var imageViewBinding: ImageViewBinding):RecyclerView.ViewHolder(imageViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewPagerRowLayoutBinding = ImageViewBinding.inflate(
            LayoutInflater.from(parent.context)
            ,parent,
            false)
        return MyViewHolder(viewPagerRowLayoutBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context)
            .load(imagesArray[position])
            .into(holder.imageViewBinding.imageView)
    }

    override fun getItemCount(): Int {
        return  imagesArray.size
    }
}