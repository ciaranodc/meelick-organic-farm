package com.meelickorganicfarm.app.compose.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.meelickorganicfarm.app.R
import com.meelickorganicfarm.app.compose.components.FarmScaffold

@Composable
fun HomeScreen(bottomNavBar: @Composable () -> Unit) {
    FarmScaffold(
        topBarTitle = stringResource(R.string.home),
        scaffoldContent = { HomeScreenContent() },
        bottomNavBar = bottomNavBar
    )
}

@Composable
fun HomeScreenContent() {
    Text(
        text = "Order status and notifications will appear here...",
        modifier = Modifier.padding(10.dp)
    )
}