package by.arsy.starwarsapp.domain.model.page

import by.arsy.starwarsapp.domain.model.item.Person

data class PersonPage(
    val count: Int,
    val next: Int?,
    val previous: Int?,
    val results: List<Person>
)
