package com.fire.stonks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fire.stonks.ui.AppNavigation

import com.fire.stonks.ui.theme.StonksTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
            StonksTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){










                }
            }

        }
        }
    }


//@Composable
//fun AppNavHost(
//    navController: NavHostController = rememberNavController(),
//    startDestination: String = MainActivity
//) {
//    NavHost(
//        navController = navController,
//        startDestination = startDestination
//    ) {
//        composable(Screen.Home.route) {
//            HomeScreen(onNavigate = { destination ->
//                navController.navigate(destination.route)
//            })
//        }
//        composable(Screen.Details.route + "/{itemId}") { backStackEntry ->
//            val itemId = backStackEntry.arguments?.getString("itemId")
//            DetailsScreen(itemId = itemId)
//        }
//        // add other destinations...
//    }
//}
//





