package com.example.practice_elsol_di

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Data class del sol (imagenes y texto)
data class PicSol(
    @DrawableRes var photoSol: Int,
    var nameSol: String
)

//Aquí ponemos las imagenes y el texto
fun getImageAndNameSol(): List<PicSol> {
    return listOf(
        PicSol(
            R.drawable.corona_solar,
            "Corona solar"
        ),
        PicSol(
            R.drawable.erupcionsolar,
            "Erupción sola"
        ),
        PicSol(
            R.drawable.corona_solar,
            "Corona Sola"
        ),
        PicSol(
            R.drawable.espiculas,
            "Espicular"
        ),
        PicSol(
            R.drawable.magnetosfera,
            "Magnetosfera"
        ),
        PicSol(
            R.drawable.manchasolar,
            "Mancha solar"
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun itemCardSol(image: PicSol){
    Card(//Las cartas del sol
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(10.dp), //La elevación de la carta
        onClick = {}
    ) {
        Column( //Creamos una columna para la foto
            Modifier.fillMaxSize()
        ) {
            Image(//Añadimos la foto
                painter = painterResource(id = image.photoSol),
                contentDescription = "photoSol",
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(220.dp), //Que opcupe todo lo ancho
                //Para mantener sus proporciones y recortarla si es necesario.
                contentScale = ContentScale.Crop
            )
            //Ahora vamos a poner una barra inferior en las imagenes
            BottomAppBar(
                modifier = Modifier.height(55.dp), //Establecemos la altura de la barra
                containerColor = Color(0xFF949494)
            ) {
                Row( //Creamos la fila para poner el nombre
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text( //Texto y lo modificamos
                        text = image.nameSol,
                        Modifier.padding(start = 10.dp),
                        color = Color.White
                    )
                    //Variable pasa cuando cliques en los 3 puntitos
                    var clickMenuVert by remember { mutableStateOf(false) }
                    //Aquí para poner los 3 puntitos a la derecha de la barra
                    IconButton(
                        onClick = {
                        clickMenuVert = true
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert, //Así los 3 puntitos
                            //Icons.Filled.Search, --> Por ejemplo asi ponemos la lupa en la derecha
                            contentDescription = "El menu de los 3 puntitos",
                            tint = Color.White
                        )
                    }

                    //Se utiliza para crear un menu desplegable, en este caso, a los 3 puntos de arriba
                    DropdownMenu(
                        //Controla si el desplegable esta visible o no
                        expanded = clickMenuVert,
                        //Para cerrar el menu si pulsas en otro lado
                        onDismissRequest = {
                        clickMenuVert = false
                        },
                        //Establece la posición del menu desplegable
                        offset = DpOffset(0.dp, ((-40).dp)),
                        //Le cambiamos el color al menu
                        modifier = Modifier.background(Color.Black)
                    ) {
                        /*
                        Ahora, el menú, vamos a crear los items
                        */
                        //Este es el primero que saldra el + "Añadir"
                        DropdownMenuItem(
                            text = {
                                   Text(
                                       //El nombre que se verá
                                       text = "Añadir",
                                       color = Color.Red,
                                       fontSize = 15.sp
                                   )
                                   },
                            //Cuando clique se cerrara (por eso lo ponemos en false)
                            onClick = {
                            clickMenuVert = false
                            },
                            //Por que así a la izquierda sale el ICONO
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Primer item del desplagable",
                                    tint = Color.Yellow
                                )
                            }
                        )
                        //Otra opción en nuestro menú desplegable
                        DropdownMenuItem(
                            text = {
                                   Text(
                                       //El nombre que se verá
                                       text = "Enviar",
                                       color = Color.Red,
                                       fontSize = 15.sp
                                   )
                                   },
                            //Cuando clique se cerrara (por eso lo ponemos en false)
                            onClick = {
                            clickMenuVert = false
                            },
                            //Por que así a la izquierda sale el ICONO
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = "Segundo item del desplagable",
                                    tint = Color.Yellow
                                )
                            }
                        )
                        //Otra opción en nuestro menú desplegable
                        DropdownMenuItem(
                            text = {
                                   Text(
                                       //El nombre que se verá
                                       text = "Eliminar",
                                       color = Color.Red,
                                       fontSize = 15.sp
                                   )
                                   },
                            //Cuando clique se cerrara (por eso lo ponemos en false)
                            onClick = {
                            clickMenuVert = false
                            },
                            //Por que así a la izquierda sale el ICONO
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Terrcer item del desplagable",
                                    tint = Color.Yellow
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}