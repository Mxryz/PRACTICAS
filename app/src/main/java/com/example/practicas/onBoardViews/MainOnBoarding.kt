package com.example.practicas.onBoardViews

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MainOnBoarding(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido a la App NFL", fontSize = 25.sp)
        Spacer(Modifier.height(40.dp))
        Button(onClick = {
            navController.navigate("Home") {
                popUpTo("OnBoarding") { inclusive = true }
            }
        }) {
            Text("Comenzar")
        }
    }
}