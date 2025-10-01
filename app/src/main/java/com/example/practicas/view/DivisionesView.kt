package com.example.practicas.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.practicas.components.MainButton
import com.example.practicas.components.Space
import com.example.practicas.components.TextView
import com.example.practicas.components.TitleBar
import com.example.practicas.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DivisionesView(navController: NavHostController, conferencia: String) {
    // Elegir las imágenes según la conferencia
    val norteImage = if (conferencia == "AFC") R.drawable.division_a_norte else R.drawable.division_n_norte
    val surImage = if (conferencia == "AFC") R.drawable.division_a_sur else R.drawable.division_n_sur
    val esteImage = if (conferencia == "AFC") R.drawable.division_a_este else R.drawable.division_n_este
    val oesteImage = if (conferencia == "AFC") R.drawable.division_a_oeste else R.drawable.division_n_oeste

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar("Divisiones $conferencia") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Atrás",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Fila superior: Norte y Sur
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = norteImage),
                        contentDescription = "Norte",
                        modifier = Modifier.size(180.dp)
                    )
                    Space(espacio = 8)
                    MainButton(
                        name = "NORTE",
                        backColor = Color.DarkGray,
                        color = Color.White,
                        modifier = Modifier.width(150.dp)
                    ) {
                        navController.navigate(if(conferencia=="AFC") "Teams/AFC North" else "Teams/NFC North")
                    }
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = surImage),
                        contentDescription = "Sur",
                        modifier = Modifier.size(180.dp)
                    )
                    Space(espacio = 8)
                    MainButton(
                        name = "SUR",
                        backColor = Color.DarkGray,
                        color = Color.White,
                        modifier = Modifier.width(150.dp)
                    ) {
                        navController.navigate(if(conferencia=="AFC") "Teams/AFC South" else "Teams/NFC South")
                    }
                }
            }

            Space(espacio = 16)

            // Fila inferior: Este y Oeste
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = esteImage),
                        contentDescription = "Este",
                        modifier = Modifier.size(180.dp)
                    )
                    Space(espacio = 8)
                    MainButton(
                        name = "ESTE",
                        backColor = Color.DarkGray,
                        color = Color.White,
                        modifier = Modifier.width(150.dp)
                    ) {
                        navController.navigate(if(conferencia=="AFC") "Teams/AFC East" else "Teams/NFC East")
                    }
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = oesteImage),
                        contentDescription = "Oeste",
                        modifier = Modifier.size(180.dp)
                    )
                    Space(espacio = 8)
                    MainButton(
                        name = "OESTE",
                        backColor = Color.DarkGray,
                        color = Color.White,
                        modifier = Modifier.width(150.dp)
                    ) {
                        navController.navigate(if(conferencia=="AFC") "Teams/AFC West" else "Teams/NFC West")
                    }
                }
            }

            Space(espacio = 24)

            // Botón regresar a conferencias
            MainButton(
                name = "REGRESAR A CONFERENCIAS",
                backColor = Color.Red,
                color = Color.White,
                modifier = Modifier.width(250.dp)
            ) {
                navController.popBackStack()
            }
        }
    }
}

@Composable
fun MainButton(
    name: String,
    backColor: Color,
    color: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = backColor)
    ) {
        Text(
            text = name.uppercase(),
            color = color,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
        )
    }
}


