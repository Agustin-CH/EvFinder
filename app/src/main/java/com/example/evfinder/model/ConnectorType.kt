package com.example.evfinder.model

enum class ConnectorType(
    val displayName: String,
    val description: String,
    val iconName: String
) {
    TYPE_2("Tipo 2 (Mennekes)", "Estándar AC hasta 22 kW - Mayoría de híbridos y EVs", "AC"),
    CCS_2("CCS Tipo 2 (Combo)", "Carga Rápida DC hasta 350 kW - Estándar europeo/latam", "DC"),
    CHADEMO("CHAdeMO", "Carga Rápida DC - Modelos asiáticos (Nissan, Mitsubishi)", "DC"),
    GBT("GB/T", "Carga Rápida DC/AC - Estándar chino (BYD, Jac, Chery)", "DC"),
    TESLA("Tesla Supercharger", "Conector propietario/NACS para vehículos Tesla", "DC")
}
