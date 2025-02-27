package com.example.jetpackcomposeui.model

data class ProductModel(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val image: String,
    val price: Double,
    val rating: Rating
)

