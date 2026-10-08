package by.arsy.starwarsapp.domain.model.page

import by.arsy.starwarsapp.domain.model.item.Film

data class FilmPage(
    val count: Int,
    val next: Int?,
    val previous: Int?,
    val results: List<Film>
)