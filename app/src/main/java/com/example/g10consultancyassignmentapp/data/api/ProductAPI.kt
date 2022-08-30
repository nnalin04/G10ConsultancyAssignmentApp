package com.example.g10consultancyassignmentapp.data.api

import com.example.g10consultancyassignmentapp.data.model.ProductAPIResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {
    @GET("products")
    suspend fun getProductApiResponse(): Response<ProductAPIResponse>
}