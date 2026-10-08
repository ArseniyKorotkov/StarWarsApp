package by.arsy.starwarsapp.data.dto.item

import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.item.Starship
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class StarshipDto(
    val name: String,
    val model: String,
    val manufacturer: String,
    @SerialName("cost_in_credits")
    val costInCredits: String,
    val length: String,
    @SerialName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    @SerialName("cargo_capacity")
    val cargoCapacity: String,
    val consumables: String,
    @SerialName("hyperdrive_rating")
    val hyperdriveRating: String,
    val MGLT: String,
    @SerialName("starship_class")
    val starshipClass: String,
    val pilots: List<String>,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String,
) {

    fun map(): Starship = Starship(
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
        hyperdriveRating = this.hyperdriveRating,
        MGLT = this.MGLT,
        starshipClass = this.starshipClass,
        pilotIdList = this.pilots.map { it.parseUslToId() },
        filmIdList = this.films.map { it.parseUslToId() },
        created = Instant.parse(/* text = */ this.created),
        edited = Instant.parse(/* text = */ this.edited)
    )

}
