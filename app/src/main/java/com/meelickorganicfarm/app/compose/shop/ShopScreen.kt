package com.meelickorganicfarm.app.compose.shop

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.meelickorganicfarm.app.R
import com.meelickorganicfarm.app.compose.components.FarmScaffold

@Composable
fun ShopScreen(
    onCategoryClick: () -> Unit,
    bottomNavBar: @Composable () -> Unit
) {
    FarmScaffold(
        topBarTitle = stringResource(R.string.shop),
        scaffoldContent = { ShopScreenContent(onCategoryClick = onCategoryClick) },
        bottomNavBar = bottomNavBar
    )
}

@Composable
fun ShopScreenContent(onCategoryClick: () -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(10.dp),
        contentPadding = PaddingValues(all = 12.dp),
    ) {
        item {
            ShopProduceTypeCard(
                imageResourceId = R.drawable.vegetables,
                text = "Vegetables",
                onClick = onCategoryClick
            )
        }
        item {
            ShopProduceTypeCard(
                imageResourceId = R.drawable.honey,
                text = "Honey",
                onClick = onCategoryClick
            )
        }
        item {
            ShopProduceTypeCard(
                imageResourceId = R.drawable.eggs,
                text = "Eggs",
                onClick = onCategoryClick
            )
        }
    }
}