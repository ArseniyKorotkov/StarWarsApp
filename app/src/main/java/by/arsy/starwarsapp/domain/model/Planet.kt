package by.arsy.starwarsapp.domain.model

import java.time.Instant

data class Planet (
    val id: Int,
    val name: String,
    val rotationPeriod: Int,
    val orbitalPeriod: Int,
    val diameter: Int,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: Int,
    val population: String,
    val residentIdList: List<Int>,
    val filmIdList: List<Int>,
    val created: Instant,
    val edited: Instant,
)