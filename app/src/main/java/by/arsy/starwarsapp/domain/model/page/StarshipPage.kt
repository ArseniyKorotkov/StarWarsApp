package by.arsy.starwarsapp.domain.model.page

import by.arsy.starwarsapp.domain.model.item.Starship

data class StarshipPage(
    val count: Int,
    val next: Int?,
    val previous: Int?,
    val results: List<Starship>
)
