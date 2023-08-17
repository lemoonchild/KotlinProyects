package com.example.lab04composeandstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Define el tema principal de la aplicación
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    RecipeListScreen()
                }
            }
        }
    }
}

data class Recipe(val name: String, val imageUrl: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeListScreen() {
    // Variables de estado para el nombre y URL de la receta
    var recipeName by remember { mutableStateOf(TextFieldValue()) }
    var imageUrl by remember { mutableStateOf(TextFieldValue()) }
    // Lista mutable para almacenar las recetas
    val recipeList = remember { mutableStateListOf<Recipe>() }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        // Título de la pantalla
        Text(
            text = "Recetas de Cocina",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Entradas para el nombre y URL de la receta
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            TextField(
                value = recipeName.text,
                onValueChange = { recipeName = TextFieldValue(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                label = { Text("Nombre de la receta") }
            )
            TextField(
                value = imageUrl.text,
                onValueChange = { imageUrl = TextFieldValue(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                label = { Text("URL de la imagen") }
            )
            // Botón para agregar una nueva receta
            Button(
                onClick = {
                    if (recipeName.text.isNotBlank() && imageUrl.text.isNotBlank()) {
                        recipeList.add(Recipe(recipeName.text, imageUrl.text))
                        recipeName = TextFieldValue()
                        imageUrl = TextFieldValue()
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Agregar")
            }
        }

        // Columna de desplazamiento perezoso (LazyColumn) para mostrar la lista de recetas
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(recipeList) { recipe ->
                // Llama a la función que crea la tarjeta de receta
                RecipeCard(recipe, onDeleteRecipe = { deletedRecipe ->
                    // Elimina la receta de la lista al hacer clic en el botón "Eliminar"
                    recipeList.remove(deletedRecipe)
                })
            }
        }
    }
}

@Composable
fun RecipeCard(recipe: Recipe, onDeleteRecipe: (Recipe) -> Unit) {
    // Tarjeta que muestra la imagen, nombre de la receta y botón de eliminación
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            // Muestra la imagen de la receta
            Image(
                painter = rememberImagePainter(data = recipe.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(4.dp))
            // Muestra el nombre de la receta
            Text(
                text = recipe.name,
                style = LocalTextStyle.current.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
            // Botón para eliminar la receta
            Button(
                onClick = { onDeleteRecipe(recipe) },
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text("Eliminar")
            }
        }
    }
}
