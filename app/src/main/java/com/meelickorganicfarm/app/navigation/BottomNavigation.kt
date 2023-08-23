package com.meelickorganicfarm.app.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.meelickorganicfarm.app.R

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val items = listOf(
            BottomNavItem.Home,
            BottomNavItem.Shop
        )

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(item.iconResourceId),
                        contentDescription = item.route,
                    )
                },
                label = { Text(stringResource(id = item.labelResourceId)) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class BottomNavItem(
    val route: String,
    val iconResourceId: Int,
    val labelResourceId: Int
) {
    object Home : BottomNavItem(
        route = Routes.home,
        iconResourceId = R.drawable.ic_home,
        labelResourceId = R.string.home
    )

    object Shop : BottomNavItem(
        route = Routes.shop,
        iconResourceId = R.drawable.ic_shop,
        labelResourceId = R.string.shop
    )
}