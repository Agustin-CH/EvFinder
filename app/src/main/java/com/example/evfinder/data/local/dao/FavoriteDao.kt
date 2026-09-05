package com.example.evfinder.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.evfinder.data.local.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Query("SELECT stationId FROM favorites WHERE userId = :userId")
    fun getFavoritesForUser(userId: String): Flow<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(favorite: FavoriteEntity)

    @Query("DELETE FROM favorites WHERE userId = :userId AND stationId = :stationId")
    suspend fun removeFavorite(userId: String, stationId: String)
}
