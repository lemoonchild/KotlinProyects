package com.example.lab05madelinecastro

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
                            .padding(start = 16.dp), // Padding al inicio para el alineamiento a la izquierda
                        horizontalAlignment = Alignment.Start // Alineamiento a la izquierda
                    ) {

                        Text(
                            text = "Todos los Eventos",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.onSurface
                            ),
                            modifier = Modifier.padding(16.dp)
                        )

                        ConcertsList()
                    }
                }
            }
        }
    }
}


data class Concert(val name: String, val location: String, val imageRes: Int)

@Composable
fun getSampleConcerts(): List<Concert> {
    return listOf(
        Concert("Concierto 1", "Lugar 1", R.drawable.concierto),
        Concert("Concierto 2", "Lugar 2", R.drawable.concierto2),
        Concert("Concierto 3", "Lugar 3", R.drawable.concierto3),
        Concert("Concierto 4", "Lugar 4", R.drawable.concierto4),
    )
}

@Composable
fun getAllSampleConcerts(): List<Concert> {
    return listOf(
        Concert("Concierto A", "Lugar 1", R.drawable.concierto4),
        Concert("Concierto B", "Lugar 2", R.drawable.concierto2),
        Concert("Concierto C", "Lugar 3", R.drawable.concierto),
        Concert("Concierto D", "Lugar 4", R.drawable.concierto3),
    )
}

@Composable
fun FavoritosHeader() {
    Text("Tus Favoritos",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black)
    Spacer(modifier = Modifier.height(3.dp))
}

@Composable
fun ConcertsList() {
    val concerts = getSampleConcerts()
    val allConcerts = getAllSampleConcerts()

    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            FavoritosHeader()
            Spacer(modifier = Modifier.height(16.dp))
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
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text("Todos los Conciertos", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
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
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}



@Composable
fun ConcertCard(concert: Concert) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = concert.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = concert.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 4.dp, bottom = 2.dp)
            )
            Text(
                text = concert.location,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 2.dp, bottom = 4.dp)
            )
        }
    }
}








