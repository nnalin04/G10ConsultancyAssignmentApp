package com.example.g10consultancyassignmentapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.g10consultancyassignmentapp.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    val productList = repository.productLiveData

    init {
        loadProductDataList()
    }

    fun loadProductDataList() {
        viewModelScope.launch {
            repository.getProductData()
        }
    }

}