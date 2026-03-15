package com.example.betterroutine.modelos

data class Tarea(
    val id: Int,
    val nombre: String,
    var completada: Boolean,
    val descripcion: String,
    val esHabito: Boolean = false,
    val horaRango: String? = null,
    val diasRepeticion: List<Int> = emptyList()
)