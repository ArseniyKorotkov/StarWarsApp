package by.arsy.starwarsapp.app.view.itemView.planetView

import by.arsy.starwarsapp.domain.model.item.Film
import by.arsy.starwarsapp.domain.model.item.Person

data class PlanetState(
    val residentList: List<Person> = emptyList(),
    val filmList: List<Film> = emptyList(),
    val isResidentListLoadedState: Boolean = false,
    val isFilmListLoadedState: Boolean = false,
)
