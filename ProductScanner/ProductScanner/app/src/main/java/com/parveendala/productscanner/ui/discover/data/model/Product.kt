package com.parveendala.productscanner.ui.discover.data.model

data class Product(
    val id: String,
    val name: String,
    val brandName: String,
    val rating: String,
    val ratingCounts: String,
    val actualPrice: String,
    val offeredPrice: String,
    val offerText: String,
    val image: Int,
    val description: String,
    val colors: List<String>,
    val sizes: List<String>,
    val specifications: List<Specification>
)

data class Specification(
    val title: String,
    val value: String
)
