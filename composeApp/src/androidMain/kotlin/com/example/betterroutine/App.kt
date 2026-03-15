package com.example.betterroutine

import com.example.betterroutine.vistas.AjustesScreen
import com.example.betterroutine.vistas.HomeScreen
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import betterroutine.composeapp.generated.resources.Res
import betterroutine.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch
import com.example.betterroutine.vistas.InicioScreen
import com.example.betterroutine.vistas.AjustesScreen

enum class Pantalla {
    INICIO,
    PENDIENTES,
    GYM,
    FINANZAS,
    AJUSTES,
}

@Composable
fun App() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var pantallaActual by remember { mutableStateOf(Pantalla.INICIO) }

    var esOscuro by remember { mutableStateOf(false) }
    val colores = if (esOscuro) darkColorScheme() else lightColorScheme()

    MaterialTheme(colorScheme = colores) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Text(
                        "BetterRoutine",
                        modifier = Modifier.padding(24.dp),
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    HorizontalDivider()

                    NavigationDrawerItem(
                        label = { Text("Inicio") },
                        selected = pantallaActual == Pantalla.INICIO,
                        icon = { Icon(Icons.Filled.Home, null) },
                        onClick = {
                            pantallaActual = Pantalla.INICIO
                            scope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )

                    NavigationDrawerItem(
                        label = { Text("Pendientes") },
                        selected = pantallaActual == Pantalla.PENDIENTES,
                        icon = { Icon(Icons.Filled.DateRange, null) },
                        onClick = {
                            pantallaActual = Pantalla.PENDIENTES
                            scope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )

                    NavigationDrawerItem(
                        label = { Text("GYM") },
                        selected = pantallaActual == Pantalla.GYM,
                        icon = { Icon(Icons.Filled.DateRange, null) },
                        onClick = {
                            pantallaActual = Pantalla.GYM
                            scope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )

                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    NavigationDrawerItem(
                        label = { Text("FINANZAS") },
                        selected = pantallaActual == Pantalla.FINANZAS,
                        icon = { Icon(Icons.Filled.List, null) },
                        onClick = {
                            pantallaActual = Pantalla.FINANZAS
                            scope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    HorizontalDivider()

                    NavigationDrawerItem(
                        label = { Text("Ajustes") },
                        selected = pantallaActual == Pantalla.AJUSTES,
                        icon = { Icon(Icons.Filled.Settings, null) },
                        onClick = {
                            pantallaActual = Pantalla.AJUSTES
                            scope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        ) {
            Surface(
                modifier = Modifier.padding(),
                color = MaterialTheme.colorScheme.background
            ) {
                when (pantallaActual) {
                    Pantalla.INICIO -> InicioScreen(onMenuClick = { scope.launch { drawerState.open() } })
                    Pantalla.PENDIENTES -> PendientesScreen(onMenuClick = { scope.launch { drawerState.open() } })
                    Pantalla.GYM -> GymScreen(onMenuClick = { scope.launch { drawerState.open() } })
                    Pantalla.FINANZAS -> FinanzasScreen(onMenuClick = { scope.launch { drawerState.open() } })
                    Pantalla.AJUSTES -> AjustesScreen(
                        onMenuClick = { scope.launch { drawerState.open() } },
                        esOscuro = esOscuro,
                        onCambioTema = { esOscuro = it }
                    )
                }
            }
        }
    }
}