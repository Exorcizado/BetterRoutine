package com.example.betterroutine.persistencia

import androidx.compose.runtime.mutableStateListOf
import com.example.betterroutine.modelos.Ejercicio
import com.example.betterroutine.modelos.RutinaGym
import com.example.betterroutine.modelos.Tarea

object RepositorioLocal {
    val tareas = mutableStateListOf(
        Tarea(1, "No beber alcohol", true, "Hábito", esHabito = true),
        Tarea(2, "Meditar", false, "Hábito", esHabito = true, horaRango = "15 Min")
    )

    val rutinasGym = mutableStateListOf(
        RutinaGym(1, "Empuje (Pecho, Hombro, Tríceps)", "Lunes", true, listOf(
            Ejercicio(1, "Press de Banca", 4, 10, 60.0)
        ))
    )

    fun alternarTarea(id: Int) {
        val index = tareas.indexOfFirst { it.id == id }
        if (index != -1) tareas[index] = tareas[index].copy(completada = !tareas[index].completada)
    }
}