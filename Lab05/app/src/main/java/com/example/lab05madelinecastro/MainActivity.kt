package com.example.lab05madelinecastro

/* Madeline Nahomy Castro Morales
* Laboratorio 05
* Creacion de pantallas de concierto con Compose
* Pantalla 1 */

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab05madelinecastro.ui.theme.Lab05MadelineCastroTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab05MadelineCastroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 1.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        // Encabezado de la aplicación
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFE5DDFB)) // Cambiar color de fondo del encabezado
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "TodoEventos",
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 25.sp,
                                        color = MaterialTheme.colorScheme.onSurface // color del texto
                                    )
                                )
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                        // Mostrar lista de conciertos guardados
                        ConcertsList()
                    }
                }
            }
        }
    }
}
//Datos del concierto
data class Concert(val name: String, val location: String, val imageRes: Int)

//Funciones para obtener diferentes tipos de conciertos
//Lista de conciertos utilizados en "Your Favorites"
@Composable
fun getSampleConcerts(): List<Concert> {
    return listOf(
        Concert("The Home Team", "Los Angeles", R.drawable.concierto),
        Concert("Bring Me The Horizon", "Utilita Arena Cardiff", R.drawable.concierto2),
        Concert("Three Days Grace", "Chicago", R.drawable.concierto3),
        Concert("Dance Gavin Dance", "Salt Lake City", R.drawable.concierto4),
    )
}
// Lista de conciertos utilizados en "Details"
@Composable
fun getDetailConcerts(): List<Concert> {
    return listOf(
        Concert("Guns And Roses LA", "LA Hall", R.drawable.concierto),
        Concert("Guns And Roses Denver", "Denver Hall", R.drawable.concierto2),
        Concert("Guns And Roses New York", "Maddison Square Garden", R.drawable.concierto3),
    )
}
// Lista de conciertos utilizados en "All Concerts"
@Composable
fun getAllSampleConcerts(): List<Concert> {
    return listOf(
        Concert("Lauv", "Amsterdam", R.drawable.concierto4),
        Concert("Disturbed", "New York", R.drawable.concierto2),
        Concert("The Neighbourhood", "Chicago", R.drawable.concierto),
        Concert("Cuarteto de Nos", "La Concha Acústica", R.drawable.concierto3),
    )
}

// Composable para mostrar la lista de conciertos
@Composable
fun ConcertsList() {
    val concerts = getSampleConcerts()
    val allConcerts = getAllSampleConcerts()

    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    // Seccion de conciertos favoritos
    ) {
        item {
            Text("Your Favorites",
                fontSize = 22.sp,
                color = Color.Black)
            Spacer(modifier = Modifier.height(3.dp))
            Spacer(modifier = Modifier.height(10.dp))
        }

        itemsIndexed(concerts.chunked(2)) { index, pair ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                pair.forEach { concert ->
                    Box(
                        Modifier.weight(1f)
                    ) {
                        ConcertCard(concert)
                    }
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
        }
        // Seccion de todos los conciertos
        item {
            Text("All Concerts", fontSize = 22.sp)
            Spacer(modifier = Modifier.height(10.dp))
        }

        itemsIndexed(allConcerts.chunked(2)) { index, pair ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                pair.forEach { concert ->
                    Box(
                        Modifier.weight(1f)
                    ) {
                        ConcertCard(concert)
                    }
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
        }
    }
}

// Composable para mostrar un elemento de concierto
@Composable
fun ConcertCard(concert: Concert) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFBDDE4)) // Cambio de color a las cards
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(1.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Image(
                    painter = painterResource(id = concert.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomStart = 5.dp, bottomEnd = 5.dp)),  // Redondeo de las esquinas inferiores
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = concert.name,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp, top = 5.dp, bottom = 10.dp)  // Añadir padding al inicio (izquierda)
                )
                Text(
                    text = concert.location,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 5.dp, bottom = 10.dp)  // Añadir padding al inicio (izquierda)
                )
            }
        }
    }
}











