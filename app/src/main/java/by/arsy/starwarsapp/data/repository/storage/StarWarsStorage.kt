package by.arsy.starwarsapp.data.repository.storage

import by.arsy.starwarsapp.data.dto.FilmDto
import by.arsy.starwarsapp.data.dto.PersonDto
import by.arsy.starwarsapp.data.dto.PlanetDto
import by.arsy.starwarsapp.data.dto.SpecieDto
import by.arsy.starwarsapp.data.dto.StarshipDto
import by.arsy.starwarsapp.data.dto.VehicleDto

interface StarWarsStorage {

    suspend fun getFilm(id: Int): FilmDto

    suspend fun getPerson(id: Int): PersonDto

    suspend fun getPlanet(id: Int): PlanetDto

    suspend fun getSpecie(id: Int): SpecieDto

    suspend fun getStarship(id: Int): StarshipDto

    suspend fun getVehicle(id: Int): VehicleDto

}