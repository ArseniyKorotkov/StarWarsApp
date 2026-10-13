package by.arsy.starwarsapp.ui.screen.itemScreens.specieScreen

import by.arsy.starwarsapp.domain.model.item.Film
import by.arsy.starwarsapp.domain.model.item.Person

data class SpecieState(
    val personList: List<Person> = emptyList(),
    val filmList: List<Film> = emptyList(),
    val isPersonListLoadedState: Boolean = false,
    val isFilmListLoadedState: Boolean = false,
)
