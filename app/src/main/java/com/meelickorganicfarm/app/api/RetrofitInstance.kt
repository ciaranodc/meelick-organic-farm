package com.meelickorganicfarm.app.api

import com.meelickorganicfarm.app.data.ItemService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://meelickorganicfarm.free.beeceptor.com/api/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val itemService: ItemService by lazy {
        retrofit.create(ItemService::class.java)
    }
}