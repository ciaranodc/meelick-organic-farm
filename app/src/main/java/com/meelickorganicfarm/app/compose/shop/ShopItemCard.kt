package com.meelickorganicfarm.app.compose.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.meelickorganicfarm.app.data.ShopItem
import com.meelickorganicfarm.app.data.getShopItemImageResourceId
import com.meelickorganicfarm.app.utils.capitalized

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopItemCard(
    shopItem: ShopItem,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .padding(bottom = 26.dp)
    ) {
        Column(Modifier.fillMaxWidth()) {
            ShopItemImage(
                imageResourceId = getShopItemImageResourceId(shopItem.name),
                contentDescription = shopItem.description,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = shopItem.name.capitalized(),
                textAlign = TextAlign.Center,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun ShopItemImage(
    imageResourceId: Int,
    contentDescription: String,
    contentScale: ContentScale,
    modifier: Modifier,
) {
    Image(
        painter = painterResource(id = imageResourceId),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShopCategoryCardPreview() {
}