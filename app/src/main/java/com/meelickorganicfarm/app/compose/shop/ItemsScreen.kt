package com.meelickorganicfarm.app.compose.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.meelickorganicfarm.app.R
import com.meelickorganicfarm.app.compose.components.FarmScaffold
import com.meelickorganicfarm.app.viewmodels.ShopItemsViewModel

@Composable
fun ItemsScreen(shopItemsViewModel: ShopItemsViewModel, bottomNavBar: @Composable () -> Unit) {
    FarmScaffold(
        topBarTitle = stringResource(R.string.shop),
        scaffoldContent = { ItemsScreenContent(shopItemsViewModel) },
        bottomNavBar = bottomNavBar
    )
}

@Composable
fun ItemsScreenContent(viewModel: ShopItemsViewModel) {
    val shopItems by viewModel.items.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchVegetableItems()
    }

    Column(modifier = Modifier.padding(20.dp)) {
        if (shopItems.isEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            LazyColumn {
                items(shopItems.size) { index ->
                    Text(text = "Name: ${shopItems[index].name}")
                    Text(text = "Description: ${shopItems[index].description}")
                    Text(text = "PricePerUnit: ${shopItems[index].pricePerUnit}")
                    Text(text = "Unit: ${shopItems[index].unit}")
                    Text(text = "QuantityRemaining: ${shopItems[index].quantityRemaining}")
                    Divider()
                }
            }
        }
    }
}