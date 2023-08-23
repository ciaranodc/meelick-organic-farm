package com.meelickorganicfarm.app.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.meelickorganicfarm.app.compose.home.HomeScreen
import com.meelickorganicfarm.app.compose.shop.ShopScreen
import com.meelickorganicfarm.app.compose.theme.MeelickOrganicFarmTheme
import com.meelickorganicfarm.app.compose.welcome.WelcomeScreen
import com.meelickorganicfarm.app.navigation.BottomNavigationBar
import com.meelickorganicfarm.app.navigation.Routes

@Composable
fun FarmApp() {
    MeelickOrganicFarmTheme {
        val navController = rememberNavController()
        FarmNavHost(navController = navController)
    }
}

@Composable
fun FarmNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.welcome) {
        composable(Routes.welcome) {
            WelcomeScreen(onEnterClick = {
                navController.navigate(Routes.shop)
            })
        }
        composable(Routes.home) { HomeScreen(bottomNavBar = { BottomNavigationBar(navController) }) }
        composable(Routes.shop) { ShopScreen(bottomNavBar = { BottomNavigationBar(navController) }) }
    }
}