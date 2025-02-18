package com.example.firstcompose

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstcompose.presentation.DashboardScreen
import com.example.firstcompose.presentation.LoginScreen
import com.example.firstcompose.presentation.SplashScreen
import com.example.firstcompose.vm.AuthViewModel


sealed class Screens(val route: String) {
    object Splash : Screens("splash")
    object Login : Screens("login")
    object Dashboard : Screens("dashboard")
}

@Composable
fun AppRoutes(){
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = hiltViewModel()


    NavHost(navController, startDestination = Screens.Splash.route){
        composable(Screens.Splash.route){ SplashScreen(navController) }
        composable(Screens.Login.route){ LoginScreen(navController, authViewModel) }
        composable(Screens.Dashboard.route){ DashboardScreen(navController) }
    }
}