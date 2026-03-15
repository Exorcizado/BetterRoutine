package com.example.betterroutine.vistas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.betterroutine.persistencia.RepositorioLocal
import com.example.betterroutine.modelos.Tarea

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PendientesScreen() {
    val tareas = RepositorioLocal.tareas
    Scaffold(topBar = { CenterAlignedTopAppBar(title = { Text("Rutina y Pendientes") }) }) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
            items(tareas) { tarea ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = tarea.completada, onCheckedChange = { RepositorioLocal.alternarTarea(tarea.id) })
                        Column(modifier = Modifier.padding(start = 8.dp)) {
                            Text(tarea.nombre, style = MaterialTheme.typography.titleMedium)
                            Text(tarea.descripcion, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}