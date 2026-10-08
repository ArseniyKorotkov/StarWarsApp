package by.arsy.starwarsapp.domain.model.item

import java.time.Instant

data class Planet(
    override val id: Int,
    override val name: String,
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
) : Item()