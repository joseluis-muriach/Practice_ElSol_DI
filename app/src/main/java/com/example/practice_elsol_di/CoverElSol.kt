package com.example.practice_elsol_di

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bottomAppBarWhatsApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun coverSol(){
    //En vez de poner directamente el get, lo pasamos por una variable
    val cardList = getImageAndNameSol()

    LazyVerticalGrid(
        //Creamos columnas de dos a dos
        columns = GridCells.Fixed(2),
        //Contendrá lo de la lista que lo pasaremos por un item
        content = {
            items(cardList) { card ->
                itemCardSol(card)
            }
        }
    )
}