package com.example.g10consultancyassignmentapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.g10consultancyassignmentapp.R
import com.example.g10consultancyassignmentapp.data.model.Product
import com.example.g10consultancyassignmentapp.databinding.ProductViewBinding

class ProductAdapter constructor(
    private var data: List<Product>
): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductAdapter.ProductViewHolder {
        return ProductViewHolder(
            DataBindingUtil.inflate<ProductViewBinding>(
                LayoutInflater.from(parent.context),
                R.layout.product_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductAdapter.ProductViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ProductViewHolder constructor(
        productViewBinding: ProductViewBinding
    ): RecyclerView.ViewHolder(productViewBinding.root){
    }
}