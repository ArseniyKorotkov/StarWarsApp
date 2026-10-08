package by.arsy.starwarsapp.domain.model.page

import by.arsy.starwarsapp.domain.model.item.Vehicle

data class VehiclePage(
    val count: Int,
    val next: Int?,
    val previous: Int?,
    val results: List<Vehicle>
)
