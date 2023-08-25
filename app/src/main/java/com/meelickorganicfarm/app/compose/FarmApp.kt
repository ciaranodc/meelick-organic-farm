package com.meelickorganicfarm.app.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.meelickorganicfarm.app.compose.home.HomeScreen
import com.meelickorganicfarm.app.compose.shop.ItemDetailsScreen
import com.meelickorganicfarm.app.compose.shop.ShopScreen
import com.meelickorganicfarm.app.compose.theme.MeelickOrganicFarmTheme
import com.meelickorganicfarm.app.compose.welcome.WelcomeScreen
import com.meelickorganicfarm.app.navigation.BottomNavigationBar
import com.meelickorganicfarm.app.navigation.Routes
import com.meelickorganicfarm.app.viewmodels.ShopItemsViewModel

@Composable
fun FarmApp(
    shopItemsViewModel: ShopItemsViewModel,
) {
    MeelickOrganicFarmTheme {
        val navController = rememberNavController()
        FarmNavHost(
            shopItemsViewModel = shopItemsViewModel,
            navController = navController
        )
    }
}

@Composable
fun FarmNavHost(
    shopItemsViewModel: ShopItemsViewModel,
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Routes.welcome) {
        composable(Routes.welcome) {
            WelcomeScreen(onEnterClick = {
                navController.navigate(Routes.shop)
            })
        }
        composable(Routes.home) { HomeScreen(bottomNavBar = { BottomNavigationBar(navController) }) }
        composable(Routes.shop) {
            ShopScreen(
                shopItemsViewModel = shopItemsViewModel,
                onItemClick = { shopItem ->
                    navController.navigate("${Routes.itemDetails}/${shopItem.id}")
                },
                bottomNavBar = { BottomNavigationBar(navController) })
        }
        composable(
            "${Routes.itemDetails}/{shopItemId}",
            arguments = listOf(navArgument("shopItemId") {
                type = NavType.IntType
            })
        ) {
            ItemDetailsScreen(
                bottomNavBar = { BottomNavigationBar(navController) })
        }
    }
}