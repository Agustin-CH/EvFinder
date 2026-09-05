package com.example.evfinder.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.evfinder.data.local.entity.ChargingStationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StationDao {

    @Query("SELECT * FROM charging_stations")
    fun getAllStations(): Flow<List<ChargingStationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStations(stations: List<ChargingStationEntity>)

    @Query("DELETE FROM charging_stations")
    suspend fun clearStations()
}
