package by.arsy.starwarsapp.data.repository.storage

import by.arsy.starwarsapp.data.dto.item.FilmDto
import by.arsy.starwarsapp.data.dto.item.PersonDto
import by.arsy.starwarsapp.data.dto.item.PlanetDto
import by.arsy.starwarsapp.data.dto.item.SpecieDto
import by.arsy.starwarsapp.data.dto.item.StarshipDto
import by.arsy.starwarsapp.data.dto.item.VehicleDto
import by.arsy.starwarsapp.data.dto.page.FilmPageDto
import by.arsy.starwarsapp.data.dto.page.PersonPageDto
import by.arsy.starwarsapp.data.dto.page.PlanetPageDto
import by.arsy.starwarsapp.data.dto.page.SpeciePageDto
import by.arsy.starwarsapp.data.dto.page.StarshipPageDto
import by.arsy.starwarsapp.data.dto.page.VehiclePageDto

interface StarWarsStorage {

    suspend fun getFilm(id: Int): FilmDto

    suspend fun getPerson(id: Int): PersonDto

    suspend fun getPlanet(id: Int): PlanetDto

    suspend fun getSpecie(id: Int): SpecieDto

    suspend fun getStarship(id: Int): StarshipDto

    suspend fun getVehicle(id: Int): VehicleDto

    suspend fun getFilmPage(page: Int): FilmPageDto

    suspend fun getPersonPage(page: Int): PersonPageDto

    suspend fun getPlanetPage(page: Int): PlanetPageDto

    suspend fun getSpeciePage(page: Int): SpeciePageDto

    suspend fun getStarshipPage(page: Int): StarshipPageDto

    suspend fun getVehiclePage(page: Int): VehiclePageDto

}
