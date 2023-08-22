package com.meelickorganicfarm.app.compose.shop

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.meelickorganicfarm.app.R
import com.meelickorganicfarm.app.compose.components.FarmScaffold

@Composable
fun ShopScreen() {
    FarmScaffold(topBarTitle = "Shop", scaffoldContent = { ShopScreenContent() })
}

@Composable
fun ShopScreenContent() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(10.dp),
        contentPadding = PaddingValues(all = 12.dp),
    ) {
        item {
            ShopCategoryCard(imageResourceId = R.drawable.vegetables,
                text = "Vegetables",
                onClick = {})
        }
        item {
            ShopCategoryCard(imageResourceId = R.drawable.honey, text = "Honey", onClick = {})
        }
        item {
            ShopCategoryCard(imageResourceId = R.drawable.eggs, text = "Eggs", onClick = {})
        }
    }
}