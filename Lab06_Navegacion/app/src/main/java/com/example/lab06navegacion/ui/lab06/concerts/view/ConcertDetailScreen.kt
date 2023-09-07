package com.example.lab06navegacion.ui.lab06.concerts.view

// ConcertDetailScreen.kt

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab05madelinecastro.Concert2
import com.example.lab05madelinecastro.getConcertByName

@Composable
fun ConcertDetailScreen(nombreConcierto: String) {
    val concert = getConcertByName(nombreConcierto)

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Imagen en la parte superior
        Image(
            painter = painterResource(id = concert.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        // Cuadro que cubre la mitad inferior de la pantalla, aquí se encuentra la información de los conciertos
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Parte superior del cuadro
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp), // Espaciado vertical entre elementos
                    horizontalAlignment = Alignment.Start
                ) {
                    // Información del concierto
                    Text(text = "Place: ${concert.location}", fontSize = 18.sp)
                    Text(text = "Band: ${concert.name}", fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    // ...
                }

                // Parte inferior del cuadro
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Botón "Favorite"
                    // ...

                    // Botón "Buy"
                    // ...
                }
            }
        }
    }
}
