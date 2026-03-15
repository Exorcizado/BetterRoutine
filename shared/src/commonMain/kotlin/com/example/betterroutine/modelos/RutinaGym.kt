package com.example.betterroutine.modelos

data class RutinaGym(
    val id: Int,
    val nombre: String,
    val diaAsignado: String,
    val esPorDefecto: Boolean,
    val ejercicios: List<Ejercicio>
)