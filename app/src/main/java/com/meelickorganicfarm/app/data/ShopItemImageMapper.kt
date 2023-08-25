package com.meelickorganicfarm.app.data

import com.meelickorganicfarm.app.R

// TODO: Replace this method of loading images with image URLs where images are retrieved via URL.
//  E.g. Use Glide library which handles caching etc.
fun getShopItemImageResourceId(imageName: String): Int {
    return with(imageName) {
        when {
            contains("onion", true) -> R.drawable.onions
            contains("tomato", true) -> R.drawable.tomatoes
            contains("chilli", true) -> R.drawable.chillies
            contains("veg box", true) -> R.drawable.vegetables
            contains("honey", true) -> R.drawable.honey
            contains("eggs", true) -> R.drawable.eggs
            else -> R.drawable.vegetables
        }
    }
}