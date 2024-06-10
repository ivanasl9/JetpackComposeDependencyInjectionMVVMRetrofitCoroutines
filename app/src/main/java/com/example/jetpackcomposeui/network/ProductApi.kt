package com.example.jetpackcomposeui.network

import com.example.jetpackcomposeui.model.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): Response<List<ProductModel>>
}