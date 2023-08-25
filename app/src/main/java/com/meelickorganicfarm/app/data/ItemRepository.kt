package com.meelickorganicfarm.app.data

import android.util.Log
import com.meelickorganicfarm.app.api.RetrofitInstance
import javax.inject.Inject

class ItemRepository @Inject constructor() {
    private val itemService = RetrofitInstance.itemService

    suspend fun getShopItems(): List<ShopItem> {
        Log.d(TAG, "Getting shop items...")
        return itemService.getShopItems()
    }

    suspend fun getItemDetails(id: Int): ShopItem {
        Log.d(TAG, "Getting item details...")
        return itemService.getItemDetails(id)
    }

    companion object {
        val TAG: String = this::class.java.simpleName
    }
}