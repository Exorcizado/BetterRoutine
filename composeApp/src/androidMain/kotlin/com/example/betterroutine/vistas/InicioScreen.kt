package com.example.betterroutine.vistas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.betterroutine.persistencia.RepositorioLocal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InicioScreen() {
    val tareasPendientes = RepositorioLocal.tareas.count { !it.completada }

    Scaffold(topBar = { CenterAlignedTopAppBar(title = { Text("Resumen Diario", fontWeight = FontWeight.Bold) }) }) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Productividad", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text("Tienes $tareasPendientes tareas pendientes para hoy.")
                }
            }
        }
    }
}