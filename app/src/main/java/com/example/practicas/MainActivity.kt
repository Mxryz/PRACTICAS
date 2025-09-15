package com.example.practicas
import android.R
import android.graphics.Color.green
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
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

@Preview(showBackground = true)
@Composable
fun Calculadora() {

    var entrada by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black).padding(bottom = 35.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Pantalla
        Column(
            modifier = Modifier.fillMaxWidth().background(Color.Black).padding(top = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = entrada,
                fontSize = 45.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }

        Divider(
            color = Color.White,
            thickness = 5.dp,
            modifier = Modifier.padding(vertical = 15.dp)
        )

        val buttonModifier = Modifier.size(width = 90.dp, height = 60.dp)
        val espacio = 10.dp

        fun addToInput(value: String) {
            entrada += value
        }

        // Evaluar
        fun calculateResult() {
            try {
                // Evaluación
                val result = evaluateExpression(entrada)
                entrada = result
            } catch (e: Exception) {
                entrada = "Error"
            }
        }

        // fila 1
        Row(horizontalArrangement = Arrangement.spacedBy(espacio)) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = buttonModifier
            ) { Text("") }

            Button(
                onClick = { entrada = "" },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("AC", fontSize = 20.sp)
            }

            Button(
                onClick = {
                    if (entrada.isNotEmpty()) {
                        entrada = entrada.dropLast(1) // borra solo el ultimo digito
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("«",fontSize = 20.sp) }

            Button(
                onClick = { addToInput("/") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("/",fontSize = 20.sp) }
        }

        Spacer(modifier = Modifier.height(espacio))

        // fila 2
        Row(horizontalArrangement = Arrangement.spacedBy(espacio)) {
            listOf("7", "8", "9").forEach { number ->
                Button(
                    onClick = { addToInput(number) },
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    modifier = buttonModifier
                ) { Text(number,fontSize = 20.sp) }
            }

            Button(
                onClick = { addToInput("*") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("*",fontSize = 20.sp) }
        }

        Spacer(modifier = Modifier.height(espacio))

        // fila 3
        Row(horizontalArrangement = Arrangement.spacedBy(espacio)) {
            listOf("4", "5", "6").forEach { number ->
                Button(
                    onClick = { addToInput(number) },
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    modifier = buttonModifier
                ) { Text(number,fontSize = 20.sp) }
            }

            Button(
                onClick = { addToInput("-") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("-",fontSize = 20.sp) }
        }

        Spacer(modifier = Modifier.height(espacio))

        // fila 4
        Row(horizontalArrangement = Arrangement.spacedBy(espacio)) {
            listOf("1", "2", "3").forEach { number ->
                Button(
                    onClick = { addToInput(number) },
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    modifier = buttonModifier
                ) { Text(number,fontSize = 20.sp) }
            }

            Button(
                onClick = { addToInput("+") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("+",fontSize = 20.sp) }
        }

        Spacer(modifier = Modifier.height(espacio))

        // fila 5
        Row(horizontalArrangement = Arrangement.spacedBy(espacio)) {
            Button(
                onClick = { addToInput("%") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text("%",fontSize = 20.sp) }

            Button(
                onClick = { addToInput("0") },
                colors = ButtonDefaults.buttonColors(Color.Gray),
                modifier = buttonModifier
            ) { Text("0",fontSize = 20.sp) }

            Button(
                onClick = { addToInput(".") },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            ) { Text(".",fontSize = 20.sp) }

            Button(
                onClick = { calculateResult() },
                colors = ButtonDefaults.buttonColors(Color.Blue),
                modifier = buttonModifier
            ) { Text("=",fontSize = 20.sp) }
        }
    }
}

fun evaluateExpression(expression: String): String {
    try {
        var exp = expression.replace("x", "*")

        val regex = Regex("(?<=[-+*/%])|(?=[-+*/%])")
        val tokens = exp.split(regex).filter { it.isNotBlank() }.toMutableList()
        if (tokens.isEmpty()) return ""

        fun formatNum(num: Double): String {
            return String.format("%.6f", num).trimEnd('0').trimEnd('.')
        }

        // * y /
        var i = 0
        while (i < tokens.size) {
            when (tokens[i]) {
                "*" -> {
                    val left = tokens[i - 1].toDouble()
                    val right = tokens[i + 1].toDouble()
                    val res = left * right
                    tokens[i - 1] = formatNum(res)
                    tokens.removeAt(i)
                    tokens.removeAt(i)
                    i--
                }
                "/" -> {
                    val left = tokens[i - 1].toDouble()
                    val right = tokens[i + 1].toDouble()
                    val res = left / right
                    tokens[i - 1] = formatNum(res)
                    tokens.removeAt(i)
                    tokens.removeAt(i)
                    i--
                }
                else -> i++
            }
        }

        // %
        i = 0
        while (i < tokens.size) {
            if (tokens[i] == "%") {
                val left = tokens[i - 1].toDouble()
                val res = left / 100.0
                tokens[i - 1] = formatNum(res)
                tokens.removeAt(i)
                i--
            } else {
                i++
            }
        }

        // + y -
        i = 0
        while (i < tokens.size) {
            when (tokens[i]) {
                "+" -> {
                    val left = tokens[i - 1].toDouble()
                    val right = tokens[i + 1].toDouble()
                    val res = left + right
                    tokens[i - 1] = formatNum(res)
                    tokens.removeAt(i)
                    tokens.removeAt(i)
                    i--
                }
                "-" -> {
                    val left = tokens[i - 1].toDouble()
                    val right = tokens[i + 1].toDouble()
                    val res = left - right
                    tokens[i - 1] = formatNum(res)
                    tokens.removeAt(i)
                    tokens.removeAt(i)
                    i--
                }
                else -> i++
            }
        }

        return tokens[0]
    } catch (e: Exception) {
        return "Error"
    }
}

