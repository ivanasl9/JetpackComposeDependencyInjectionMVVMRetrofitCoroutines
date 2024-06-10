package com.example.jetpackcomposeui.network

import com.example.jetpackcomposeui.model.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductService @Inject constructor(private val api: ProductApi) {
    suspend fun getProducts(): List<ProductModel> {
        return withContext(Dispatchers.IO) {
            val products = api.getProducts()
            products.body()?: emptyList()
        }
    }
}