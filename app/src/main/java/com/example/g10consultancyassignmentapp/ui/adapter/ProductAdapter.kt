package com.example.g10consultancyassignmentapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.g10consultancyassignmentapp.R
import com.example.g10consultancyassignmentapp.data.model.Product
import com.example.g10consultancyassignmentapp.databinding.ProductViewBinding
import com.example.g10consultancyassignmentapp.ui.RecyclerViewClickListener

class ProductAdapter constructor(
    private var data: List<Product>,
    private var listener: RecyclerViewClickListener
): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductAdapter.ProductViewHolder {
        return ProductViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.product_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        with(holder) {
            with(data[position]) {
                productViewBinding.brand.text = this.brand
                productViewBinding.model.text = this.title
                productViewBinding.price.text = this.price.toString() + " $"
                Glide.with(productViewBinding.imageView)
                    .load(this.thumbnail)
                    .into(productViewBinding.imageView)
                productViewBinding.cardView.setOnClickListener{
                    listener.onRecyclerViewItemClick(this)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun updateView(data: List<Product>) {
        this.data = data
        notifyDataSetChanged()
    }

    class ProductViewHolder constructor(
        var productViewBinding: ProductViewBinding
    ): RecyclerView.ViewHolder(productViewBinding.root){
    }
}