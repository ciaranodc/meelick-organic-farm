package com.meelickorganicfarm.app.data

import retrofit2.http.GET

interface ItemService {
    @GET("vegetables")
    suspend fun getVegetableItems(): List<Item>
}