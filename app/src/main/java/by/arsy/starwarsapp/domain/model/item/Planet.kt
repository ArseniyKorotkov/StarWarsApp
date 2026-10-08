package by.arsy.starwarsapp.domain.model.item

import java.time.Instant

data class Planet(
    override val id: Int,
    override val name: String,
    val rotationPeriod: String,
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: String,
    val population: String,
    val residentIdList: List<Int>,
    val filmIdList: List<Int>,
    val created: Instant,
    val edited: Instant,
) : Item()