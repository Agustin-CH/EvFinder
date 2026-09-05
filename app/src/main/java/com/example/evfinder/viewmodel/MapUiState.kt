package com.example.evfinder.viewmodel

import com.example.evfinder.model.ChargingStation
import com.example.evfinder.model.StationFilter

data class MapUiState(
    val stations: List<ChargingStation> = emptyList(),
    val filter: StationFilter = StationFilter(),
    val selectedStation: ChargingStation? = null,
    val isFilterSheetOpen: Boolean = false,
    val isAuthDialogOpen: Boolean = false,
    val isLoading: Boolean = false,
    val userMessage: String? = null
)
