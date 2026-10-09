package by.arsy.starwarsapp.app.view.itemView.vehicleView

import by.arsy.starwarsapp.domain.model.item.Film
import by.arsy.starwarsapp.domain.model.item.Person

data class VehicleState(
    val pilotList: List<Person> = emptyList(),
    val filmList: List<Film> = emptyList(),
    val isPilotListLoadedState: Boolean = false,
    val isFilmListLoadedState: Boolean = false,
)
