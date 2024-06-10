package com.example.jetpackcomposeui.repo

import com.example.jetpackcomposeui.model.ProductItem
import com.example.jetpackcomposeui.model.toProductItem
import com.example.jetpackcomposeui.network.ProductService
import javax.inject.Inject

class ProductRepository @Inject constructor(private val service: ProductService) {
    suspend fun getProducts(): List<ProductItem> {
        return service.getProducts().map {
            it.toProductItem()
        }
    }
}