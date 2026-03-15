package com.example.betterroutine.vistas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.betterroutine.persistencia.RepositorioLocal
import com.example.betterroutine.modelos.RutinaGym
import com.example.betterroutine.modelos.Ejercicio

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GymScreen() {
    val rutinas = RepositorioLocal.rutinasGym
    Scaffold(topBar = { CenterAlignedTopAppBar(title = { Text("Gimnasio") }) }) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
            items(rutinas) { rutina ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(rutina.nombre, style = MaterialTheme.typography.titleMedium)
                        Text("Día: ${rutina.diaAsignado}")
                        rutina.ejercicios.forEach { ej ->
                            Text("• ${ej.nombre}: ${ej.sets}x${ej.repeticiones} - ${ej.peso}kg")
                        }
                    }
                }
            }
        }
    }
}