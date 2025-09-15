package com.example.practicas
import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicas.ui.theme.PRACTICASTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PRACTICASTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

data class TarifaISR(
    val limInf: Double,
    val limSup: Double?,
    val cuotaFija: Double,
    val porcentaje: Double
)

@Preview(showBackground = true)
@Composable
fun MainScreen() {
    var sueldoIngresado by remember { mutableStateOf("") }
    var resultadoISR by remember { mutableStateOf("") }
    var resultadoSueldoNeto by remember { mutableStateOf("") }

    // ISR Quincenal
    val tablaQuincenal = listOf(
        TarifaISR(0.01, 368.10, 0.0, 1.92),
        TarifaISR(368.11, 3124.35, 7.05, 6.40),
        TarifaISR(3124.36, 5490.75, 183.45, 10.88),
        TarifaISR(5490.76, 6382.80, 441.00, 16.00),
        TarifaISR(6382.81, 7641.90, 583.65, 17.92),
        TarifaISR(7641.91, 15412.80, 809.25, 21.36),
        TarifaISR(15412.81, 24292.65, 2469.15, 23.52),
        TarifaISR(24292.66, 46378.50, 4557.75, 30.00),
        TarifaISR(46378.51, 61838.10, 11183.40, 32.00),
        TarifaISR(61838.11, 185514.30, 16130.55, 34.00),
        TarifaISR(185514.31, null, 58180.35, 35.00)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row() {
            //Imagen del sat
            Image(
                painter = painterResource( R.drawable.sat),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = sueldoIngresado,
                onValueChange = { sueldoIngresado = it },
                label = { Text("Sueldo quincenal") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón Calcular
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    val sueldoIngresadoNum = if (sueldoIngresado.isNotEmpty()) sueldoIngresado.toDouble() else 0.0

                    var tarifaSeleccionada: TarifaISR? = null
                    for (t in tablaQuincenal) {
                        if (sueldoIngresadoNum >= t.limInf &&
                            (t.limSup == null || sueldoIngresadoNum <= t.limSup)
                        ) {
                            tarifaSeleccionada = t
                            break
                        }
                    }

                    if (tarifaSeleccionada != null) {
                        val excedente = sueldoIngresadoNum - tarifaSeleccionada.limInf
                        var calculoISR = (excedente * tarifaSeleccionada.porcentaje / 100) + tarifaSeleccionada.cuotaFija
                        var calculoSueldoNeto = sueldoIngresadoNum - calculoISR

                        if (calculoISR < 0) calculoISR = 0.0
                        if (calculoSueldoNeto < 0) calculoSueldoNeto = 0.0

                        // Formato 2 decimales
                        resultadoISR = String.format("%.2f", calculoISR)
                        resultadoSueldoNeto = String.format("%.2f", calculoSueldoNeto)
                    } else {
                        resultadoISR = "0.00"
                        resultadoSueldoNeto = String.format("%.2f", sueldoIngresadoNum)
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text("Calcular")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ISR calculado
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = resultadoISR,
                onValueChange = {},
                readOnly = true,
                label = { Text("ISR") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sueldo final
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = resultadoSueldoNeto,
                onValueChange = {},
                readOnly = true,
                label = { Text("Sueldo Final") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón Borrar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    sueldoIngresado = ""
                    resultadoISR = ""
                    resultadoSueldoNeto = ""
                },
                colors = ButtonDefaults.buttonColors(Color.Red)
            ) {
                Text("Borrar", color = Color.White)
            }
        }
    }
}


