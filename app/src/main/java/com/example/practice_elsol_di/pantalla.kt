package com.example.practice_elsol_di

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun prueba(navController: NavHostController) {//Tengo que añadir esto para que navegue
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Esta ventana abre PRUEBA! :)")
    }
}