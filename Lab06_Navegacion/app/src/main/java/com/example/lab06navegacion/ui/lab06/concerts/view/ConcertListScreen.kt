package com.example.lab06navegacion.ui.lab06.concerts.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab06navegacion.Concert
import com.example.lab06navegacion.ConcertCard

@Composable
fun ConcertListScreen() {
    val concerts = getSampleConcerts()
    val allConcerts = getAllSampleConcerts()

    LazyColumn(
        contentPadding = PaddingValues(16.dp)
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
