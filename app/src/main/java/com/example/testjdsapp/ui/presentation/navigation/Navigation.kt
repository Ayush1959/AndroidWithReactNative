package com.example.testjdsapp.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testjdsapp.ui.presentation.screens.greeting.GreetingScreen
import com.example.testjdsapp.ui.presentation.screens.hijds.HiJdsScreen

sealed class Screen(val route: String) {
    object Greeting : Screen("greeting")
    object HiJds : Screen("hijds")
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Greeting.route,
        modifier = modifier
    ) {
        composable(Screen.Greeting.route) {
            GreetingScreen(
                onNavigateToHiJds = {
                    navController.navigate(Screen.HiJds.route) {
                        popUpTo(Screen.Greeting.route) { inclusive = false }
                    }
                }
            )
        }
        
        composable(Screen.HiJds.route) {
            HiJdsScreen(
                onNavigateToGreeting = {
                    navController.navigate(Screen.Greeting.route) {
                        popUpTo(Screen.HiJds.route) { inclusive = false }
                    }
                }
            )
        }
    }
}
