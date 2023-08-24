package com.meelickorganicfarm.app.data

data class Item(
    val id: Int,
    val name: String,
    val description: String,
    val pricePerUnit: Float,
    val unit: String,
    val quantityRemaining: Int
)