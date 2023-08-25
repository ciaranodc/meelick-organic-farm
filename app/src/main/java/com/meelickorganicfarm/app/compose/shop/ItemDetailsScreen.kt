package com.meelickorganicfarm.app.compose.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meelickorganicfarm.app.R
import com.meelickorganicfarm.app.compose.components.FarmScaffold
import com.meelickorganicfarm.app.viewmodels.ItemDetailsViewModel

@Composable
fun ItemDetailsScreen(
    itemDetailsViewModel: ItemDetailsViewModel = hiltViewModel(),
    bottomNavBar: @Composable () -> Unit
) {
    FarmScaffold(
        topBarTitle = stringResource(R.string.product_details),
        scaffoldContent = { ItemDetailsScreenContent(itemDetailsViewModel) },
        bottomNavBar = bottomNavBar
    )
}

@Composable
fun ItemDetailsScreenContent(itemDetailsViewModel: ItemDetailsViewModel) {
    val itemDetails = itemDetailsViewModel.item.observeAsState().value

    LaunchedEffect(Unit) {
        itemDetailsViewModel.fetchItemDetails()
    }

    Column(modifier = Modifier.padding(20.dp)) {
        if (itemDetails == null) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            Text(text = "Name: ${itemDetails.name}")
            Text(text = "Description: ${itemDetails.description}")
            Text(text = "Price per unit: €${itemDetails.pricePerUnit}")
            Text(text = "Unit: ${itemDetails.unit}")
            Text(text = "Quantity remaining: ${itemDetails.quantityRemaining}")
        }
    }
}