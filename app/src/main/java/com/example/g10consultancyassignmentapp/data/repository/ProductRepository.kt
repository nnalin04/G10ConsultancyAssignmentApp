package com.example.g10consultancyassignmentapp.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.g10consultancyassignmentapp.data.Response
import com.example.g10consultancyassignmentapp.data.api.ProductAPI
import com.example.g10consultancyassignmentapp.data.model.Product
import com.example.g10consultancyassignmentapp.utils.NetworkUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productAPI: ProductAPI,
    @ApplicationContext private val context: Context
) {

    private val _productLiveData = MutableLiveData<Response<List<Product>>>()
    val productLiveData: LiveData<Response<List<Product>>>
        get() = _productLiveData

    suspend fun getProductData() {
        _productLiveData.postValue(Response.Loading())
        try {
            if (NetworkUtils.isInternetAvailable(context)) {
                val response = productAPI.getProductApiResponse()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _productLiveData.postValue(Response.Success(it.products))
                    }
                } else {
                    _productLiveData.postValue(Response.Error("Invalid URL Link"))
                    Log.e("MyTag", "Invalid URl Link")
                }
            } else {
                _productLiveData.postValue(Response.Error("Network Error"))
            }
        } catch (e : Exception) {
            Log.e("MyTag", e.printStackTrace().toString())
            _productLiveData.postValue(Response.Error("Some Error occurred"))
        }
    }
}