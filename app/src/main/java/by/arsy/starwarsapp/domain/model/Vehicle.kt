package by.arsy.starwarsapp.domain.model

import java.time.Instant

data class Vehicle (
    val id: Int,
    val name: String,
    val model: String,
    val manufacturer: String,
    val costInCredits: String,
    val length: String,
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val vehicleClass: String,
    val pilotIdList: List<Int>,
    val filmIdList: List<Int>,
    val created: Instant,
    val edited: Instant,
)
