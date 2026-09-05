package com.example.evfinder.data.local.entity

import androidx.room.Entity

@Entity(tableName = "favorites", primaryKeys = ["userId", "stationId"])
data class FavoriteEntity(
    val userId: String,
    val stationId: String
)
