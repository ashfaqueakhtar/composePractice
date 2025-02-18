package com.example.firstcompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstcompose.R
import com.example.firstcompose.Screens
import com.example.firstcompose.vm.AuthViewModel


@Preview(showSystemUi = true)
@Composable
fun ShowPreview() {
    val passwordVisible = rememberSaveable { mutableStateOf(true) }

    //
    val userName = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    //

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Login Here",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Input(
            state = userName,
            label = "UserName",
        )
        Input(
            state = password,
            label = "Password",
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            passwordVisible = passwordVisible
        )
        Button(onClick = {

        }) {
            Text("Submit", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
        }
    }
}

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel) {
    val passwordVisible = rememberSaveable { mutableStateOf(true) }

    //
    val userName = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    //

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            "Login Here",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Input(
            state = userName,
            label = "UserName",
        )
        Input(
            state = password,
            label = "Password",
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            passwordVisible = passwordVisible
        )
        Button(onClick = {
            authViewModel.onLogin(userName.value, password.value)
            if (authViewModel.isLoggedIn.value) {
                navController.navigate(Screens.Dashboard.route) {
                    popUpTo(Screens.Login.route) { inclusive = true }
                }
            }
        }) {
            Text("Submit", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
        }
    }
}


@Composable
fun Input(
    label: String,
    paddingBottom: Dp = 10.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
    passwordVisible: MutableState<Boolean> = mutableStateOf(true),
    state: MutableState<String>,
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = paddingBottom),
        value = state.value,
        keyboardOptions = keyboardOptions,
        visualTransformation = if (!passwordVisible.value && label == "Password") PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon =
        {
            if (label == "Password") {
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    /*Icon(
                        imageVector = if (passwordVisible.value) Icons.Filled.Email else Icons.Filled.Send,
                        contentDescription = "Show Password"
                    )*/
                    Image(
                        painterResource(if (passwordVisible.value) R.drawable.show else R.drawable.hide),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                }
            } else {
                Unit
            }
        },
        onValueChange = {
            state.value = it
        },
        label = {
            Text(label)
        },
    )
}