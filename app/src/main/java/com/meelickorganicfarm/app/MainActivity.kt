package com.meelickorganicfarm.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.meelickorganicfarm.app.compose.FarmApp
import com.meelickorganicfarm.app.data.ItemRepository
import com.meelickorganicfarm.app.viewmodels.ShopItemsViewModel
import com.meelickorganicfarm.app.viewmodels.ShopItemsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val itemRepository = ItemRepository()

    private val shopItemsViewModel: ShopItemsViewModel by viewModels {
        ShopItemsViewModelFactory(itemRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FarmApp(
                shopItemsViewModel = shopItemsViewModel,
            )
        }
    }
}