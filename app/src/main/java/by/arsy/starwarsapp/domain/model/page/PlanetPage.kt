package by.arsy.starwarsapp.domain.model.page

import by.arsy.starwarsapp.domain.model.item.Planet

data class PlanetPage(
    val count: Int,
    val next: Int?,
    val previous: Int?,
    val results: List<Planet>
)
