package by.arsy.starwarsapp.domain.model.page

import by.arsy.starwarsapp.domain.model.item.Specie

data class SpeciePage(
    val count: Int,
    val next: Int?,
    val previous: Int?,
    val results: List<Specie>
)
