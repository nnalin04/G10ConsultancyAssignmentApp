package com.example.g10consultancyassignmentapp.ui

import com.example.g10consultancyassignmentapp.data.model.Product

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(product: Product)
}