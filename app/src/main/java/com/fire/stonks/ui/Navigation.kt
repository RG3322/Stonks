package com.fire.stonks.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fire.stonks.domain.model.CompanyItem
import com.fire.stonks.ui.screens.HomeScreen
import com.fire.stonks.ui.screens.SearchScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavGraph(navController)
}

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = "home")
        {
            composable("home") {
                CompanyItem(navController)
            }
            composable("search") {
                SearchScreen(navController)
            }
        }
}