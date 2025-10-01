package com.example.practicas.view

import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import kotlin.collections.listOf
import com.example.practicas.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeamsView(navController: NavHostController, divisionId: String) {

    val teams = when (divisionId) {
        "AFC East" -> listOf(
            "Buffalo Bills" to R.drawable.buffalo_bills,
            "Miami Dolphins" to R.drawable.miami_dolphins,
            "New England Patriots" to R.drawable.new_england_patriots,
            "New York Jets" to R.drawable.new_york_jets
        )
        "AFC South" -> listOf(
            "Houston Texans" to R.drawable.houston_texans,
            "Indianapolis Colts" to R.drawable.baltimore_colts,
            "Jacksonville Jaguars" to R.drawable.jacksonville_jaguars,
            "Tennessee Titans" to R.drawable.tennessee_titans
        )
        "AFC North" -> listOf(
            "Baltimore Ravens" to R.drawable.baltimore_ravens,
            "Cincinnati Bengals" to R.drawable.cincinnati_bengals,
            "Cleveland Browns" to R.drawable.cleveland_browns,
            "Pittsburgh Steelers" to R.drawable.pittsburgh_steelers
        )
        "AFC West" -> listOf(
            "Denver Broncos" to R.drawable.denver_broncos,
            "Kansas City Chiefs" to R.drawable.kansas_city_chiefs,
            "Las Vegas Raiders" to R.drawable.las_vegas_raiders,
            "Los Angeles Chargers" to R.drawable.los_angeles_chargers
        )
        "NFC East" -> listOf(
            "Dallas Cowboys" to R.drawable.dallas_cowboys,
            "Philadelphia Eagles" to R.drawable.philadelphia_eagles,
            "New York Giants" to R.drawable.new_york_giants,
            "Washington Commanders" to R.drawable.washington_commanders
        )
        "NFC South" -> listOf(
            "Atlanta Falcons" to R.drawable.atlanta_falcons,
            "Carolina Panthers" to R.drawable.carolina_panthers,
            "New Orleans Saints" to R.drawable.new_orleans_saints,
            "Tampa Bay Buccaneers" to R.drawable.tampa_bay_buccaneers
        )
        "NFC North" -> listOf(
            "Chicago Bears" to R.drawable.chicago_bears,
            "Detroit Lions" to R.drawable.detroit_lions,
            "Green Bay Packers" to R.drawable.green_bay_packers,
            "Minnesota Vikings" to R.drawable.minnesota_vikings
        )
        "NFC West" -> listOf(
            "Arizona Cardinals" to R.drawable.arizona_cardinals,
            "Los Angeles Rams" to R.drawable.angeles_rams,
            "San Francisco 49ers" to R.drawable.san_francisco,
            "Seattle Seahawks" to R.drawable.seattle_seahawks
        )
        else -> emptyList()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "EQUIPOS DE $divisionId",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Regresar",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.DarkGray
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            teams.forEach { (teamName, imageId) ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = imageId),
                        contentDescription = teamName,
                        modifier = Modifier
                            .size(150.dp)
                            .clickable {
                                // Navegación hacia TeamDetailsView usando el nombre exacto
                                navController.navigate("TeamDetail/$teamName")
                            }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = teamName.uppercase(),
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
            }
        }
    }
}

