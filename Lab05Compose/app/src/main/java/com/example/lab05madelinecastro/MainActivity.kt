package com.example.lab05madelinecastro

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab05madelinecastro.ui.theme.Lab05MadelineCastroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab05MadelineCastroTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConcertsActivity()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConcertsActivity() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Todos los Eventos") },
            )
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.primary) // Set background color here
    ) {
        ConcertsList()
    }
}


@Composable
fun ConcertsList() {
    val concerts = getSampleConcerts()

    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        items(concerts) { concert ->
            ConcertCard(concert)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ConcertCard(concert: Concert) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = concert.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = concert.location)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = concert.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

data class Concert(val name: String, val location: String, val imageRes: Int)

@Composable
fun getSampleConcerts(): List<Concert> {
    return listOf(
        Concert("Concierto 1", "Lugar 1", R.drawable.concierto),
        Concert("Concierto 2", "Lugar 2", R.drawable.concierto2),
    )
}

