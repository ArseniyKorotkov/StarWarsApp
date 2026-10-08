package by.arsy.starwarsapp.data.dto.item

import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.item.Person
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class PersonDto(
    val name: String,
    val height: String,
    val mass: String,
    @SerialName("hair_color")
    val hairColor: String,
    @SerialName("skin_color")
    val skinColor: String,
    @SerialName("eye_color")
    val eyeColor: String,
    @SerialName("birth_year")
    val birthYear: String,
    val gender: String,
    val homeworld: String,
    val films: List<String>,
    val species: List<String>,
    val vehicles: List<String>,
    val starships: List<String>,
    val created: String,
    val edited: String,
    val url: String,
) {

    fun map(): Person = Person(
        id = this.url.parseUslToId(),
        name = this.name,
        height = this.height,
        mass = this.mass,
        hairColor = this.hairColor,
        skinColor = this.skinColor,
        eyeColor = this.eyeColor,
        birthYear = this.birthYear,
        gender = this.gender,
        homeworld = this.homeworld.parseUslToId(),
        filmIdList = this.films.map { it.parseUslToId() },
        specieIdList = this.species.map { it.parseUslToId() },
        vehicleIdList = this.vehicles.map { it.parseUslToId() },
        starshipIdList = this.starships.map { it.parseUslToId() },
        created = Instant.parse(/* text = */ this.created),
        edited = Instant.parse(/* text = */ this.edited)
    )

}