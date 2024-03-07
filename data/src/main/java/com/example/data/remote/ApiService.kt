package com.example.data.remote

import com.example.data.dto.ProductsResponse
import com.example.data.dto.ProductsResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): Response<List<ProductsResponseItem>>
}