package by.arsy.starwarsapp.ui.screen.itemScreens.filmScreen

import by.arsy.starwarsapp.domain.model.item.Person
import by.arsy.starwarsapp.domain.model.item.Planet
import by.arsy.starwarsapp.domain.model.item.Specie
import by.arsy.starwarsapp.domain.model.item.Starship
import by.arsy.starwarsapp.domain.model.item.Vehicle

data class FilmState(
    val personList: List<Person> = emptyList(),
    val planetList: List<Planet> = emptyList(),
    val starshipList: List<Starship> = emptyList(),
    val vehicleList: List<Vehicle> = emptyList(),
    val specieList: List<Specie> = emptyList(),
    val isPersonListLoadedState: Boolean = false,
    val isPlanetListLoadedState: Boolean = false,
    val isStarshipListLoadedState: Boolean = false,
    val isVehicleListLoadedState: Boolean = false,
    val isSpecieListLoadedState: Boolean = false,
)
