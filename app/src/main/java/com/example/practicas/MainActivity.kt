package com.example.practicas
import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicas.ui.theme.PRACTICASTheme

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
                    Calculadora()
                }
            }
        }
    }
}

@Composable
fun Calculadora() {
    // Estado para mostrar la operación y resultado
    var input by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        // Pantalla superior
        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = input,
                fontSize = 32.sp,
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )
        }

        val buttonModifier = Modifier.size(width = 90.dp, height = 60.dp)
        val espacio = 10.dp

        fun addInput(value: String) {
            input += value
        }

        // Función para evaluar la operación
        fun calculateResult() {
            try {
                // Evaluación usando Kotlin
                val result = evaluateExpression(input)
                input = result
            } catch (e: Exception) {
                input = "Error"
            }
        }

        // row 1
        Row(horizontalArrangement = Arrangement.spacedBy(espacio)) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = buttonModifier
            ) { Text("") }

            Button(
                onClick = { input = "" },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("AC") }

            Button(
                onClick = { addInput("x") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) {
                if (input.isNotEmpty()) input = input.dropLast(1)
                Text("x")
            }

            Button(
                onClick = { addInput("/") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("/") }
        }

        Spacer(modifier = Modifier.height(espacio))

        // row2
        Row(horizontalArrangement = Arrangement.spacedBy(espacio)) {
            listOf("7", "8", "9").forEach { number ->
                Button(
                    onClick = { addInput(number) },
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    modifier = buttonModifier
                ) { Text(number) }
            }

            Button(
                onClick = { addInput("*") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("*") }
        }

        Spacer(modifier = Modifier.height(espacio))

        // row 3
        Row(horizontalArrangement = Arrangement.spacedBy(espacio)) {
            listOf("4", "5", "6").forEach { number ->
                Button(
                    onClick = { addInput(number) },
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    modifier = buttonModifier
                ) { Text(number) }
            }

            Button(
                onClick = { addInput("-") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("-") }
        }

        Spacer(modifier = Modifier.height(espacio))

        // row 4
        Row(horizontalArrangement = Arrangement.spacedBy(espacio)) {
            listOf("1", "2", "3").forEach { number ->
                Button(
                    onClick = { addInput(number) },
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    modifier = buttonModifier
                ) { Text(number) }
            }

            Button(
                onClick = { addInput("+") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("+") }
        }

        Spacer(modifier = Modifier.height(espacio))

        // row 5
        Row(horizontalArrangement = Arrangement.spacedBy(espacio)) {
            Button(
                onClick = { addInput("%") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("%") }

            Button(
                onClick = { addInput("0") },
                colors = ButtonDefaults.buttonColors(Color.Gray),
                modifier = buttonModifier
            ) { Text("0") }

            Button(
                onClick = { addInput(".") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text(".") }

            Button(
                onClick = { calculateResult() },
                colors = ButtonDefaults.buttonColors(Color.Blue),
                modifier = buttonModifier
            ) { Text("=" )}
        }
    }
}

fun evaluateExpression(expression: String): String {
    return try {
        val sanitized = expression.replace("x", "*")
        val result = when {
            sanitized.contains("+") -> {
                val parts = sanitized.split("+")
                parts[0].toDouble() + parts[1].toDouble()
            }
            sanitized.contains("-") -> {
                val parts = sanitized.split("-")
                parts[0].toDouble() - parts[1].toDouble()
            }
            sanitized.contains("*") -> {
                val parts = sanitized.split("*")
                parts[0].toDouble() * parts[1].toDouble()
            }
            sanitized.contains("/") -> {
                val parts = sanitized.split("/")
                parts[0].toDouble() / parts[1].toDouble()
            }
            sanitized.contains("%") -> {
                val parts = sanitized.split("%")
                parts[0].toDouble() % parts[1].toDouble()
            }
            else -> sanitized.toDouble()
        }
        result.toString()
    } catch (e: Exception) {
        "Error"
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCalculadora() {
    PRACTICASTheme {
        Calculadora()
    }
}
