package by.arsy.starwarsapp.data.dto

import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.Planet
import java.time.Instant

data class PlanetDto(
    val name: String,
    val rotationPeriod: String,
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: String,
    val population: String,
    val residents: List<String>,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String,
) {

    fun map(): Planet = Planet(
        id = this.url.parseUslToId(),
        name = this.name,
        rotationPeriod = this.rotationPeriod.toInt(),
        orbitalPeriod = this.orbitalPeriod.toInt(),
        diameter = this.diameter.toInt(),
        climate = this.climate,
        gravity = this.gravity,
        terrain = this.terrain,
        surfaceWater = this.surfaceWater.toInt(),
        population = this.population,
        residentIdList = this.residents.map { it.parseUslToId() },
        filmIdList = this.films.map { it.parseUslToId() },
        created = Instant.parse( /* text = */ this.created),
        edited = Instant.parse( /* text = */ this.edited)
    )

}