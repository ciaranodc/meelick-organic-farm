package com.meelickorganicfarm.app.data

import android.util.Log
import com.meelickorganicfarm.app.api.RetrofitInstance

class ItemRepository {
    private val itemService = RetrofitInstance.itemService

    suspend fun getVegetableItems(): List<Item> {
        Log.d("ItemRepository", "Getting vegetable items...")
        return itemService.getVegetableItems()
    }
}