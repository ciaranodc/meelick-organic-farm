package com.meelickorganicfarm.app.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ItemService {
    @GET("shop/items")
    suspend fun getShopItems(): List<ShopItem>

    @GET("shop/items/{id}")
    suspend fun getItemDetails(
        @Path("id") itemId: Int
    ): ShopItem
}