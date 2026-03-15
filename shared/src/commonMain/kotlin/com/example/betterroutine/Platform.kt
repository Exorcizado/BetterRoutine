package com.example.betterroutine

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform