package com.example.practicas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicas.onBoardViews.MainOnBoarding
import com.example.practicas.view.*


@Composable
fun NavManager() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Splash"
    ) {
        composable("Splash") { SplashScreen(navController) }
        composable("OnBoarding") { MainOnBoarding(navController) }
        composable("Home") { HomeView(navController) }

        composable(
            "Divisions/{confId}",
            arguments = listOf(navArgument("confId") { type = NavType.StringType })
        ) { backStackEntry ->
            val confId = backStackEntry.arguments?.getString("confId") ?: ""
            DivisionesView(navController, conferencia = confId)
        }

        composable(
            "Teams/{divisionId}",
            arguments = listOf(navArgument("divisionId") { type = NavType.StringType })
        ) { backStackEntry ->
            val divisionId = backStackEntry.arguments?.getString("divisionId") ?: ""
            TeamsView(navController, divisionId)
        }

        composable(
            "TeamDetail/{teamId}",
            arguments = listOf(navArgument("teamId") { type = NavType.StringType })
        ) { backStackEntry ->
            val teamId = backStackEntry.arguments?.getString("teamId") ?: ""
            TeamDetailsView(navController, teamId)
        }
    }
}

