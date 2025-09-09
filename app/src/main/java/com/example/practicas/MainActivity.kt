package com.example.practicas

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                ){
                    Greeting()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Greeting(){

    val context=LocalContext.current
    var texto by remember { mutableStateOf("") }
    var texto2 by remember { mutableStateOf("") }
    var ValorA by remember {mutableStateOf("")}
    var ValorB by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }


    Column (modifier = Modifier.fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Row(modifier = Modifier.padding(0.dp,0.dp,0.dp,20.dp)){
            OutlinedTextField(
                value=ValorA,
                label={Text("Primer Valor")},
                onValueChange ={ValorA=it}
            )
        }
        Row(modifier = Modifier.padding(0.dp,0.dp,0.dp,20.dp)){
            OutlinedTextField(
                value=ValorB,
                label={Text("Segundo Valor")},
                onValueChange ={ValorB=it}
            )
        }
        Row(modifier = Modifier.padding(0.dp,0.dp,0.dp,20.dp)) {
            OutlinedButton(onClick = {/*TODO*/
                val a=ValorA.toInt()
                val b=ValorB.toInt()
                val c=a+b
                resultado=c.toString()
            })
            {
                Text("Enviar", color = Color.Black)
            }
            OutlinedButton(onClick = {/*TODO*/

            })
            {
                Text("Borrar", color = Color.Black)
            }
        }

        Row(){
            OutlinedTextField(
                value=resultado,
                label={Text("Resultado")},
                onValueChange ={resultado=it}
            )
        }
        }

}

