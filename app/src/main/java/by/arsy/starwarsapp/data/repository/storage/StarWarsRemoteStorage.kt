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
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class StarWarsRemoteStorage(
    private val httpClient: HttpClient
) : StarWarsStorage {

    override suspend fun getFilm(id: Int): FilmDto {
        return httpClient.get(urlString = "films/$id").body()
    }

    override suspend fun getPerson(id: Int): PersonDto {
        return httpClient.get(urlString = "people/$id").body()
    }

    override suspend fun getPlanet(id: Int): PlanetDto {
        return httpClient.get(urlString = "planets/$id").body()
    }

    override suspend fun getSpecie(id: Int): SpecieDto {
        return httpClient.get(urlString = "species/$id").body()
    }

    override suspend fun getStarship(id: Int): StarshipDto {
        return httpClient.get(urlString = "starships/$id").body()
    }

    override suspend fun getVehicle(id: Int): VehicleDto {
        return httpClient.get(urlString = "vehicles/$id").body()
    }

    override suspend fun getFilmPage(page: Int): FilmPageDto {
        return httpClient.get(urlString = "films/?page=$page").body()
    }

    override suspend fun getPersonPage(page: Int): PersonPageDto {
        return httpClient.get(urlString = "people/?page=$page").body()
    }

    override suspend fun getPlanetPage(page: Int): PlanetPageDto {
        return httpClient.get(urlString = "planets/?page=$page").body()
    }

    override suspend fun getSpeciePage(page: Int): SpeciePageDto {
        return httpClient.get(urlString = "species/?page=$page").body()
    }

    override suspend fun getStarshipPage(page: Int): StarshipPageDto {
        return httpClient.get(urlString = "starships/?page=$page").body()
    }

    override suspend fun getVehiclePage(page: Int): VehiclePageDto {
        return httpClient.get(urlString = "vehicles/?page=$page").body()
    }

}
