package com.example.firstcompose.vm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() :ViewModel(){

    var isLoggedIn = mutableStateOf(false)

    fun onLogin(username: String, password: String) {
        ///DO all Checks
        if (username == "user" && password == "password") {
            isLoggedIn.value = true
        }
    }
}