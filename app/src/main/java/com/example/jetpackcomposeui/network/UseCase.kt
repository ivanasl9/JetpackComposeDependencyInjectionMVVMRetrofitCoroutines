package com.example.jetpackcomposeui.network

import com.example.jetpackcomposeui.model.ProductItem
import com.example.jetpackcomposeui.repo.ProductRepository
import javax.inject.Inject

class UseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(): List<ProductItem> {
        return productRepository.getProducts()
    }
}