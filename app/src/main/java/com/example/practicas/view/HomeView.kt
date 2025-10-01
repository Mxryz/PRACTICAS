package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.practicas.R
import com.example.practicas.components.ActionButton
import com.example.practicas.components.MainButton
import com.example.practicas.components.Space
import com.example.practicas.components.TextView
import com.example.practicas.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("CONFERENCIAS NFL") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        },
        floatingActionButton = { ActionButton() }
    ) {
        ContentHomeView(navController)
    }
}

@Composable
fun ContentHomeView(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.american_football_conference),
                contentDescription = "Conferencia A",
                modifier = Modifier.size(150.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.national_football_conference),
                contentDescription = "Conferencia N",
                modifier = Modifier.size(150.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        MainButton(
            name = "CONFERENCIA AMERICAN",
            backColor = Color.Red,
            color = Color.White
        ) {
            navController.navigate("Divisions/AFC")
        }

        Spacer(modifier = Modifier.height(16.dp))

        MainButton(
            name = "CONFERENCIA NATIONAL",
            backColor = Color.Blue,
            color = Color.White
        ) {
            navController.navigate("Divisions/NFC")
        }

    }
}




