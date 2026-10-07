package by.arsy.starwarsapp.data.dto

import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.Vehicle
import java.time.Instant

data class VehicleDto(
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
    val pilots: List<String>,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String,
) {

    fun map(): Vehicle = Vehicle(
        id = this.url.parseUslToId(),
        name = this.name,
        model = this.model,
        manufacturer = this.manufacturer,
        costInCredits = this.costInCredits,
        length = this.length,
        maxAtmospheringSpeed = this.maxAtmospheringSpeed,
        crew = this.crew,
        passengers = this.passengers,
        cargoCapacity = this.cargoCapacity,
        consumables = this.consumables,
        vehicleClass = this.vehicleClass,
        pilotIdList = this.pilots.map { it.parseUslToId() },
        filmIdList = this.films.map { it.parseUslToId() },
        created = Instant.parse(/* text = */ this.created),
        edited = Instant.parse(/* text = */ this.edited)
    )

}
