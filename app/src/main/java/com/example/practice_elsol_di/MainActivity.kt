package com.example.practice_elsol_di

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import bottomAppBarWhatsApp
import com.example.practice_elsol_di.ui.theme.Practice_ElSol_DITheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practice_ElSol_DITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Creo la variable para navegar
                    val navController  = rememberNavController()
                    //Donde empezara el programa será en el cover
                    NavHost(navController = navController, startDestination = "Cover"){
                        //Creo el composable para poder iniciar en COVER
                        composable("Cover") { bottomAppBarWhatsApp(navController) }
                        //Esto por que ire de COVER a otra pantalla
                        composable("pantalla") { prueba(navController)}

                    }
                }
            }
        }
    }
}
