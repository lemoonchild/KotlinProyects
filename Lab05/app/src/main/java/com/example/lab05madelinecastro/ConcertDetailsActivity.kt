package com.example.lab05madelinecastro

/* Madeline Nahomy Castro Morales
* Laboratorio 05
* Creacion de pantallas de concierto con Compose
* Pantalla 3 */

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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

class ConcertDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Detalle sdel concierto
            ConcertDetail()
        }
    }
}

// Se crea un nuevo data class de Concert ya que tiene mas propiedades
data class Concert2(val name: String, val location: String, val imageRes: Int, val date: String, val time: String, val description: String)

@Composable
fun ConcertDetail() {
    // Informacion de concierto a utilizar
    val concert = Concert2("The Home Team", "Los Angeles", R.drawable.concierto, "07/10/2023", "19:00", "Don Broco & The Home Team\n" + "Sat • Oct 07 • 7:00 PM\n" + "The Belasco, Los Angeles, CA")

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

        // Cuadro que cubre la mitad inferior de la pantalla, aqui se encuentra la información de los conciertos
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
                    // Informacion del concierto
                    Text(text = "Place: ${concert.location}", fontSize = 18.sp)
                    Text(text = "Band: ${concert.name}", fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(imageVector = Icons.Default.CalendarToday, contentDescription = null) // icono de calendario
                            // Fecha del concierto al lado de icono
                            Text(text = "Date: ${concert.date}", fontSize = 16.sp)
                        }
                        // Hora del concierto
                        Text(text = "Hour: ${concert.time}", fontSize = 16.sp)
                    }
                    // Informacion extra sobre el concierto
                    Text(text = "About:", fontSize = 16.sp)
                    Text(text = concert.description, fontSize = 16.sp)
                }

                // Parte inferior del cuadro
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Boton "Favorite"
                    Button(
                        onClick = { /* no hace nada */ },
                        colors = ButtonDefaults.buttonColors(Color(0xFFE5DDFB), contentColor = Color.Black)

                    ) {
                        Text(text = "Favorite")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    // Boton "Buy"
                    Button(
                        onClick = { /* no hace nada */ },
                        colors = ButtonDefaults.buttonColors(Color(0xFFE5DDFB), contentColor = Color.Black)
                    ) {
                        Text(text = "Buy")
                    }
                }

            }
        }
    }
}





