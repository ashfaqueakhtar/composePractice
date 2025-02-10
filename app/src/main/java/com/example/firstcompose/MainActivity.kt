package com.example.firstcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.firstcompose.ui.theme.FirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*FirstComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android"
                    )
                }
            }*/
            //Greeting(name = "Android")
            InputField()
        }
    }
}

@Composable
fun Submit() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            disabledContainerColor = Color.White
        )
    ) {

        Text(
            text = "Submit",
        )
    }
}

@Composable
fun PreviewFunction() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "",
        colorFilter = ColorFilter.tint(Color.Cyan),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color.Blue,
        textAlign = TextAlign.Center
    )
}

@Composable
fun InputField() {
    val  state = remember{mutableStateOf("")}
    TextField(
        value = state.value,
        onValueChange = {
        state.value = it
                        },
        label = {
        Text("Hint Text")
    })
}

@Preview(showBackground = true /*widthDp = 200, heightDp = 200*/)
@Composable
fun GreetingPreview() {
    /*FirstComposeTheme {
        Greeting("Android")
    }*/
    //PreviewFunction()
    //Submit()
    InputField()
}