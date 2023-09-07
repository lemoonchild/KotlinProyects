package com.example.lab06navegacion.ui.lab06.concerts.view

// ConcertCard.kt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab05madelinecastro.Concert
import androidx.compose.ui.draw.clip
import com.example.lab05madelinecastro.ConcertCard

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
