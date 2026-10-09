package by.arsy.starwarsapp.app.view.itemView.starshipView

import by.arsy.starwarsapp.domain.model.item.Film
import by.arsy.starwarsapp.domain.model.item.Person

data class StarshipState(
    val pilotList: List<Person> = emptyList(),
    val filmList: List<Film> = emptyList(),
    val isPilotListLoadedState: Boolean = false,
    val isFilmListLoadedState: Boolean = false,
)
