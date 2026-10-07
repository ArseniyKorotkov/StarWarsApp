package by.arsy.starwarsapp.domain.model

import java.time.Instant

data class Film (
    val id: Int,
    val title: String,
    val episodeId: Int,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val releaseDate: Instant,
    val characters: List<Int>,
    val planetIdList: List<Int>,
    val starshipIdList: List<Int>,
    val vehicleIdList: List<Int>,
    val specieIdList: List<Int>,
    val created: Instant,
    val edited: Instant,
)