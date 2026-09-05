package com.example.evfinder.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.evfinder.model.ChargingStation
import com.example.evfinder.model.ConnectorType
import com.example.evfinder.model.StationStatus

@Entity(tableName = "charging_stations")
data class ChargingStationEntity(
    @PrimaryKey val id: String,
    val name: String,
    val operator: String,
    val address: String,
    val city: String,
    val latitude: Double,
    val longitude: Double,
    val powerKw: Int,
    val connectorsRaw: String, // Comma separated connector names (e.g. "CCS_2,TYPE_2")
    val statusRaw: String,      // Status name (e.g. "AVAILABLE")
    val pricePerKwh: Double,
    val openingHours: String,
    val rating: Double,
    val totalPlugs: Int,
    val availablePlugs: Int
) {
    fun toDomainModel(): ChargingStation {
        val connectorsList = connectorsRaw.split(",").mapNotNull { name ->
            try { ConnectorType.valueOf(name.trim()) } catch (e: Exception) { null }
        }
        val stationStatus = try {
            StationStatus.valueOf(statusRaw)
        } catch (e: Exception) {
            StationStatus.AVAILABLE
        }

        return ChargingStation(
            id = id,
            name = name,
            operator = operator,
            address = address,
            city = city,
            latitude = latitude,
            longitude = longitude,
            powerKw = powerKw,
            connectors = connectorsList,
            status = stationStatus,
            pricePerKwh = pricePerKwh,
            openingHours = openingHours,
            rating = rating,
            totalPlugs = totalPlugs,
            availablePlugs = availablePlugs
        )
    }

    companion object {
        fun fromDomainModel(station: ChargingStation): ChargingStationEntity {
            return ChargingStationEntity(
                id = station.id,
                name = station.name,
                operator = station.operator,
                address = station.address,
                city = station.city,
                latitude = station.latitude,
                longitude = station.longitude,
                powerKw = station.powerKw,
                connectorsRaw = station.connectors.joinToString(",") { it.name },
                statusRaw = station.status.name,
                pricePerKwh = station.pricePerKwh,
                openingHours = station.openingHours,
                rating = station.rating,
                totalPlugs = station.totalPlugs,
                availablePlugs = station.availablePlugs
            )
        }
    }
}
