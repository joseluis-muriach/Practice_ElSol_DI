import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.practice_elsol_di.coverSol
import com.example.practice_elsol_di.ui.theme.Purple40
import com.example.practice_elsol_di.ui.theme.Purple80
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun bottomAppBarWhatsApp(navController: NavController) {
    val scope = rememberCoroutineScope()
    //Esta no es necesaria por que es para el menu lateral ese cuando le das a la flecha
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)//Cerrado inicialmente
    //Esta variable hace un count de las veces que clicas
    var badgeCount by remember { mutableStateOf(0) }

    //Importantisimo el Scaffold, tanto para TOP BAR como BOTTOM BAR
    Scaffold(
        //Esto también para que se ponga en la parte inferior, si pusieramos TopBar iria arriba
        bottomBar = {
            BottomAppBar(
                containerColor = Purple40,
                contentColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 5.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        //Este lo estamos creando para la flecha
                        IconButton(
                            onClick = {
                                //Si clicas se "abre"
                                scope.launch { drawerState.open() }
                            }
                        ) {
                            Icon(//Icono de la flecha
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                        //Este lo estamos creando para lo de settings con el contador
                        BadgedBox(badge = {
                            Badge {
                                Text(text = badgeCount.toString())
                            }

                        }, modifier = Modifier
                            .padding(10.dp)
                            .clickable { badgeCount++ }) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                    //Puedo meter un texto si quiero
                    Text(text = "Aquí podría poner algo")
                    //Depues creo el floating por ejemplo
                    FloatingActionButton(onClick = {
                        //Aquí voy a navegar a otra pantalla, lo he hecho para probar
                        navController.navigate("pantalla")
                                                   }, containerColor = Purple80) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }

                }
            }
        }
    ) {
        //En las propiedades del Scaffold no, depués añadiriamos la cover
        coverSol()
    } //Fin Scaffold
}