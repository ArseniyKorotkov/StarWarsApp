package by.arsy.starwarsapp.data.dto.item

import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.item.Film
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class FilmDto(
    val title: String,
    @SerialName("episode_id")
    val episodeId: Int,
    @SerialName("opening_crawl")
    val openingCrawl: String,
    val director: String,
    val producer: String,
    @SerialName("release_date")
    val releaseDate: String,
    val characters: List<String>,
    val planets: List<String>,
    val starships: List<String>,
    val vehicles: List<String>,
    val species: List<String>,
    val created: String,
    val edited: String,
    val url: String,
) {

    fun map(): Film = Film(
        id = this.url.parseUslToId(),
        title = this.title,
        episodeId = this.episodeId,
        openingCrawl = this.openingCrawl,
        director = this.director,
        producer = this.producer,
        releaseDate = Instant.parse( /* text = */ this.releaseDate),
        characters = this.characters.map { it.parseUslToId() },
        planetIdList = this.planets.map { it.parseUslToId() },
        starshipIdList = this.starships.map { it.parseUslToId() },
        vehicleIdList = this.vehicles.map { it.parseUslToId() },
        specieIdList = this.species.map { it.parseUslToId() },
        created = Instant.parse(/* text = */ this.created),
        edited = Instant.parse(/* text = */ this.edited)
    )

}