package by.arsy.starwarsapp.app.view.personView

import by.arsy.starwarsapp.domain.model.item.Film
import by.arsy.starwarsapp.domain.model.item.Specie
import by.arsy.starwarsapp.domain.model.item.Starship
import by.arsy.starwarsapp.domain.model.item.Vehicle

data class PersonState(
    val filmList: List<Film> = emptyList(),
    val specieList: List<Specie> = emptyList(),
    val vehicleList: List<Vehicle> = emptyList(),
    val starshipList: List<Starship> = emptyList(),
    val isFilmListLoadedState: Boolean = false,
    val isSpecieListLoadedState: Boolean = false,
    val isVehicleListLoadedState: Boolean = false,
    val isStarshipListLoadedState: Boolean = false,
)