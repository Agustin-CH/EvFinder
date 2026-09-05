package com.example.evfinder.model

enum class PowerCategory(val label: String, val minKw: Int, val maxKw: Int) {
    ALL("Todas las potencias", 0, 1000),
    SLOW_AC("Lenta AC (<= 22 kW)", 0, 22),
    FAST_DC("Rápida DC (22-100 kW)", 23, 100),
    ULTRA_FAST("Ultra Rápida DC (> 100 kW)", 101, 1000)
}
