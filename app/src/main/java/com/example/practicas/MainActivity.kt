package com.example.practicas
import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

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
fun Greeting() {


    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom )
    {

        val buttonModifier = Modifier.size(width = 90.dp, height = 60.dp)
        val espacio = 10.dp

        Row( horizontalArrangement = Arrangement.spacedBy(espacio))
        {
            Button(
                onClick = {/*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = buttonModifier
            )
            {
                Text("")
            }
            Button( onClick = {/*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            )
    {
             Text(" AC ")
    }
            Button(
                onClick = {/*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            )
            { Text(" x ")
            }

            Button(
                onClick = {/*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            )
            {
                Text(" / ")
            }
        }

        Spacer(modifier = Modifier.height(espacio))

    Row(horizontalArrangement = Arrangement.spacedBy(espacio))
    {
        Button(
            onClick = {/*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = buttonModifier
        )
        {
            Text("7")
        }

        Button(
            onClick = {/*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = buttonModifier
        ) {
            Text("8")
        }

        Button(
            onClick = {/*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = buttonModifier
        )
        {
            Text("9")
        }

        Button(
            onClick = {/*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            modifier = buttonModifier
        )
           {
            Text("*")
            }
    }

        Spacer(modifier = Modifier.height(espacio))

    Row(horizontalArrangement = Arrangement.spacedBy(espacio))
    {
        Button(
            onClick = {/*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = buttonModifier
        )
        {
            Text("4")
        }
        Button(
            onClick = {/*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = buttonModifier
        )
        {
            Text("5")
        }
        Button(
            onClick = {/*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = buttonModifier
        )
        {
            Text("6")
        }
        Button(
            onClick = {/*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            modifier = buttonModifier
        )
        {
            Text("-")
        }
    }
        Spacer(modifier = Modifier.height(espacio))

        Row(horizontalArrangement = Arrangement.spacedBy(espacio))
        {
            Button(
                onClick = {/*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Gray),
                modifier = buttonModifier
            )
            {
                Text("1")
            }
            Button(
                onClick = {/*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Gray),
                modifier = buttonModifier
            )
            {
                Text("2")
            }
            Button(
                onClick = {/*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Gray),
                modifier = buttonModifier
            )
            {
                Text("3")
            }
            Button(
                onClick = {/*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            )
            {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(espacio))

        Row(horizontalArrangement = Arrangement.spacedBy(espacio))
        {
            Button(
                onClick = {/*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            )
            {
                Text("%")
            }

            Button( onClick = {/*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Gray),
                modifier = buttonModifier
            )
            {
                Text("0")
            }

            Button(
                    onClick = {/*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
                modifier = buttonModifier
            )
            {
                Text(".") }

            Button( onClick = {/*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Blue) ,
            modifier = buttonModifier
            )
            { Text("=")
            }
        }
    }
}
