package by.arsy.starwarsapp.domain

import by.arsy.starwarsapp.domain.model.Film
import by.arsy.starwarsapp.domain.model.Person
import by.arsy.starwarsapp.domain.model.Planet
import by.arsy.starwarsapp.domain.model.Specie
import by.arsy.starwarsapp.domain.model.Starship
import by.arsy.starwarsapp.domain.model.Vehicle

interface StarWarsRepository {

    suspend fun getFilm(id: Int): Film

    suspend fun getPerson(id: Int): Person

    suspend fun getPlanet(id: Int): Planet

    suspend fun getSpecie(id: Int): Specie

    suspend fun getStarship(id: Int): Starship

    suspend fun getVehicle(id: Int): Vehicle

}