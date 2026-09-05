package com.example.evfinder.model

data class ChargingStation(
    val id: String,
    val name: String,
    val operator: String,
    val address: String,
    val city: String,
    val latitude: Double,
    val longitude: Double,
    val powerKw: Int,
    val connectors: List<ConnectorType>,
    val status: StationStatus,
    val pricePerKwh: Double,
    val openingHours: String = "24 Horas",
    val rating: Double = 4.8,
    val totalPlugs: Int = 2,
    val availablePlugs: Int = 1
)
