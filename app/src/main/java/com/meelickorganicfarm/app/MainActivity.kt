package com.meelickorganicfarm.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.meelickorganicfarm.app.compose.FarmApp
import com.meelickorganicfarm.app.viewmodels.ShopItemsViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: ShopItemsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FarmApp(shopItemsViewModel = viewModel)
        }
    }
}