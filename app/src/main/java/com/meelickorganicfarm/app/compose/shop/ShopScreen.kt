package com.meelickorganicfarm.app.compose.shop

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.meelickorganicfarm.app.R
import com.meelickorganicfarm.app.compose.components.FarmScaffold
import com.meelickorganicfarm.app.data.ShopItem
import com.meelickorganicfarm.app.viewmodels.ShopItemsViewModel

@Composable
fun ShopScreen(
    onItemClick: (ShopItem) -> Unit,
    bottomNavBar: @Composable () -> Unit,
    shopItemsViewModel: ShopItemsViewModel
) {
    val shopItems by shopItemsViewModel.items.observeAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        shopItemsViewModel.fetchShopItems()
    }

    FarmScaffold(
        topBarTitle = stringResource(R.string.shop),
        scaffoldContent = { ShopScreenContent(shopItems = shopItems, onItemClick = onItemClick) },
        bottomNavBar = bottomNavBar
    )
}

@Composable
fun ShopScreenContent(shopItems: List<ShopItem>, onItemClick: (ShopItem) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(10.dp),
        contentPadding = PaddingValues(all = 12.dp),
    ) {

        items(
            items = shopItems,
            key = { it.id }
        ) { shopItem ->
            ShopItemCard(shopItem = shopItem) {
                onItemClick(shopItem)
            }
        }
    }
}