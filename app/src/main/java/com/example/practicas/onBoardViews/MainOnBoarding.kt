package com.example.practicas.onBoardViews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practicas.R

@Composable
fun MainOnBoarding(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFE31837), Color(0xFF002244))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.nfl),
                contentDescription = "NFL Logo",
                modifier = Modifier.size(270.dp)
            )

            Spacer(modifier = Modifier.height(2.dp))


            Text(
                text = "¡Bienvenido a la App NFL!",
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))


            Text(
                text = "Descubre los equipos, historias y estadísticas de la NFL",
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.9f),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))


            Button(
                onClick = {
                    navController.navigate("Home") {
                        popUpTo("OnBoarding") { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFB612)),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .height(55.dp)
                    .fillMaxWidth(0.7f)
            ) {
                Text(
                    text = "¡Comenzar!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
}