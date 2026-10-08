package by.arsy.starwarsapp.data.dto.item

import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.item.Specie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class SpecieDto(
    val name: String,
    val classification: String,
    val designation: String,
    @SerialName("average_height")
    val averageHeight: String,
    @SerialName("skin_colors")
    val skinColors: String,
    @SerialName("hair_colors")
    val hairColors: String,
    @SerialName("eye_colors")
    val eyeColors: String,
    @SerialName("average_lifespan")
    val averageLifespan: String,
    val homeworld: String,
    val language: String,
    val people: List<String>,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String,
) {

    fun map(): Specie = Specie(
        id = this.url.parseUslToId(),
        name = this.name,
        classification = this.classification,
        designation = this.designation,
        averageHeight = this.averageHeight,
        skinColors = this.skinColors,
        hairColors = this.hairColors,
        eyeColors = this.eyeColors,
        averageLifespan = this.averageLifespan,
        homeworld = this.homeworld.parseUslToId(),
        language = this.language,
        personIdList = this.people.map { it.parseUslToId() },
        filmIdList = this.films.map { it.parseUslToId() },
        created = Instant.parse(/* text = */ this.created),
        edited = Instant.parse(/* text = */ this.edited)
    )

}
