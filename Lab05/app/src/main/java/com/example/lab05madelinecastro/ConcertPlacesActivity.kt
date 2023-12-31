package com.example.lab05madelinecastro

/* Madeline Nahomy Castro Morales
* Laboratorio 05
* Creacion de pantallas de concierto con Compose
* Pantalla 2 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConcertPlacesList() {
    val concerts = getDetailConcerts() // Función para obtener los datos de los conciertos

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Lista de conciertos
        LazyColumn(
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Bloques donde se encuentran los conciertos
            items(concerts) { concert ->
                ConcertBlock(concert)

                Spacer(modifier = Modifier.height(15.dp))
                // Barra que divide los elementos
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }
        }
    }
}
@Composable
fun ConcertBlock(concert: Concert) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Spacer(modifier = Modifier.width(1.dp))

        // Círculo con color y letra "A" al lado izquierdo
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color(0xFFE5DDFB), shape = CircleShape)
                .align(Alignment.CenterVertically),
            contentAlignment = Alignment.Center
        ) {
            Text(
                // Texto dentro del circulo
                text = "A",
                fontSize = 25.sp,
                color = Color(0xFF3A2F71),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.width(10.dp))  // Espacio entre el circulo y el texto

        // Texto del concierto y el lugar al lado de la circulo
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                // Informaciond de conciertos
                text = concert.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            // Informacion de lugares
            Text(
                text = concert.location,
                fontSize = 16.sp
            )
        }

        // Triángulo en la parte derecha
        Icon(
            imageVector = Icons.Default.KeyboardArrowUp,
            contentDescription = null,
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.width(16.dp))  // Espaciado en el lado derecho
    }
}

class ConcertPlacesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Muestra la lista de lugares de conciertos
            ConcertPlacesList()
        }
    }
}
