package com.meelickorganicfarm.app.compose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FarmScaffold(
    topBarTitle: String,
    scaffoldContent: @Composable () -> Unit,
    bottomNavBar: @Composable () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(topBarTitle) })
        },
        content = { contentPadding ->
            Box(modifier = Modifier.padding(contentPadding)) {
                scaffoldContent()
            }
        },
        bottomBar = {
            bottomNavBar()
        })
}