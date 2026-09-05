package com.example.evfinder.model

data class StationFilter(
    val searchQuery: String = "",
    val powerCategory: PowerCategory = PowerCategory.ALL,
    val selectedConnectors: Set<ConnectorType> = emptySet(),
    val statusFilter: StationStatus? = null
) {
    val isActive: Boolean
        get() = searchQuery.isNotBlank() ||
                powerCategory != PowerCategory.ALL ||
                selectedConnectors.isNotEmpty() ||
                statusFilter != null
}
