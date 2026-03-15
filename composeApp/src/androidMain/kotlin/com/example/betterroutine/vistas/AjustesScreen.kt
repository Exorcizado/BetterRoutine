package com.example.betterroutine.vistas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.betterroutine.persistencia.RepositorioLocal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AjustesScreen(esOscuro: Boolean, onCambioTema: (Boolean) -> Unit) {
    var mostrarDialogo by remember { mutableStateOf(false) }

    Scaffold(topBar = { CenterAlignedTopAppBar(title = { Text("Ajustes") }) }) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Modo Oscuro", modifier = Modifier.weight(1f))
                Switch(checked = esOscuro, onCheckedChange = onCambioTema)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { mostrarDialogo = true }, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)) {
                Text("Borrar todos los datos")
            }
        }

        if (mostrarDialogo) {
            AlertDialog(
                onDismissRequest = { mostrarDialogo = false },
                title = { Text("¿Borrar Datos?") },
                text = { Text("Perderás tu progreso de rutinas y tareas.") },
                confirmButton = {
                    Button(onClick = {
                        RepositorioLocal.tareas.clear()
                        RepositorioLocal.rutinasGym.clear()
                        mostrarDialogo = false
                    }) { Text("Confirmar") }
                },
                dismissButton = {
                    TextButton(onClick = { mostrarDialogo = false }) { Text("Cancelar") }
                }
            )
        }
    }
}