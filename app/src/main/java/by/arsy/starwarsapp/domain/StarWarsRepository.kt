package by.arsy.starwarsapp.domain

import by.arsy.starwarsapp.domain.model.item.Film
import by.arsy.starwarsapp.domain.model.item.Person
import by.arsy.starwarsapp.domain.model.item.Planet
import by.arsy.starwarsapp.domain.model.item.Specie
import by.arsy.starwarsapp.domain.model.item.Starship
import by.arsy.starwarsapp.domain.model.item.Vehicle
import by.arsy.starwarsapp.domain.model.page.FilmPage
import by.arsy.starwarsapp.domain.model.page.PersonPage
import by.arsy.starwarsapp.domain.model.page.PlanetPage
import by.arsy.starwarsapp.domain.model.page.SpeciePage
import by.arsy.starwarsapp.domain.model.page.StarshipPage
import by.arsy.starwarsapp.domain.model.page.VehiclePage

interface StarWarsRepository {

    suspend fun getFilm(id: Int): Film

    suspend fun getPerson(id: Int): Person

    suspend fun getPlanet(id: Int): Planet

    suspend fun getSpecie(id: Int): Specie

    suspend fun getStarship(id: Int): Starship

    suspend fun getVehicle(id: Int): Vehicle

    suspend fun getFilmPage(page: Int): FilmPage

    suspend fun getPersonPage(page: Int): PersonPage

    suspend fun getPlanetPage(page: Int): PlanetPage

    suspend fun getSpeciePage(page: Int): SpeciePage

    suspend fun getStarshipPage(page: Int): StarshipPage

    suspend fun getVehiclePage(page: Int): VehiclePage

}