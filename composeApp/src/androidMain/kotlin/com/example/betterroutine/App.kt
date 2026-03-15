package com.example.betterroutine

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.betterroutine.vistas.AjustesScreen
import com.example.betterroutine.vistas.GymScreen
import com.example.betterroutine.vistas.InicioScreen
import com.example.betterroutine.vistas.PendientesScreen

enum class Pantalla {
    INICIO,
    PENDIENTES,
    GYM,
    AJUSTES
}

@Composable
fun App() {
    var pantallaActual by remember { mutableStateOf(Pantalla.INICIO) }
    var esOscuro by remember { mutableStateOf(false) }

    MaterialTheme(colorScheme = if (esOscuro) darkColorScheme() else lightColorScheme()) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(icon = { Icon(Icons.Filled.Home, null) }, label = { Text("Inicio") }, selected = pantallaActual == Pantalla.INICIO, onClick = { pantallaActual = Pantalla.INICIO })
                    NavigationBarItem(icon = { Icon(Icons.Filled.Check, null) }, label = { Text("Rutina") }, selected = pantallaActual == Pantalla.PENDIENTES, onClick = { pantallaActual = Pantalla.PENDIENTES })
                    NavigationBarItem(icon = { Icon(Icons.Filled.Person, null) }, label = { Text("Gym") }, selected = pantallaActual == Pantalla.GYM, onClick = { pantallaActual = Pantalla.GYM })
                    NavigationBarItem(icon = { Icon(Icons.Filled.Settings, null) }, label = { Text("Ajustes") }, selected = pantallaActual == Pantalla.AJUSTES, onClick = { pantallaActual = Pantalla.AJUSTES })
                }
            }
        ) { paddingValues ->
            Surface(modifier = Modifier.fillMaxSize().padding(paddingValues), color = MaterialTheme.colorScheme.background) {
                when (pantallaActual) {
                    Pantalla.INICIO -> InicioScreen()
                    Pantalla.PENDIENTES -> PendientesScreen()
                    Pantalla.GYM -> GymScreen()
                    Pantalla.AJUSTES -> AjustesScreen(esOscuro = esOscuro, onCambioTema = { esOscuro = it })
                }
            }
        }
    }
}