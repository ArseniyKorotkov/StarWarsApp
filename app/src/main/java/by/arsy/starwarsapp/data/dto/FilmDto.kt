package by.arsy.starwarsapp.data.dto

import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.Film
import java.time.Instant

data class FilmDto(
    val title: String,
    val episodeId: Int,
    val openingCrawl: String,
    val director: String,
    val producer: String,
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