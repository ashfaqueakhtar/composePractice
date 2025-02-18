package com.example.firstcompose.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Preview(showSystemUi = true)
@Composable
fun ShowPreview() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Login Here", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Input("UserName")
        Input("Password")
    }
}

@Composable
fun LoginScreen(navController: NavController) {
    Column() {
        Text("Login Here", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Input("UserName")
        Input("Password")
    }
}


@Composable
fun Input(label: String, paddingBottom: Float? = null) {
    val state = remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        value = state.value,
        onValueChange = {
            state.value = it
        },
        label = {
            Text(label)
        })
}