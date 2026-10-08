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

class StarWarsRemoteStorage : StarWarsStorage {

    val ktorClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
        defaultRequest {
            url(urlString = "https://swapi.dev/api/")
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            header(HttpHeaders.UserAgent, "StarWarsApp")
        }
    }

    override suspend fun getFilm(id: Int): FilmDto {
        return ktorClient.get(urlString = "films/$id").body()
    }

    override suspend fun getPerson(id: Int): PersonDto {
        return ktorClient.get(urlString = "people/$id").body()
    }

    override suspend fun getPlanet(id: Int): PlanetDto {
        return ktorClient.get(urlString = "planets/$id").body()
    }

    override suspend fun getSpecie(id: Int): SpecieDto {
        return ktorClient.get(urlString = "species/$id").body()
    }

    override suspend fun getStarship(id: Int): StarshipDto {
        return ktorClient.get(urlString = "starships/$id").body()
    }

    override suspend fun getVehicle(id: Int): VehicleDto {
        return ktorClient.get(urlString = "vehicles/$id").body()
    }

    override suspend fun getFilmPage(page: Int): FilmPageDto {
        return ktorClient.get(urlString = "films/?page=$page").body()
    }

    override suspend fun getPersonPage(page: Int): PersonPageDto {
        return ktorClient.get(urlString = "people/?page=$page").body()
    }

    override suspend fun getPlanetPage(page: Int): PlanetPageDto {
        return ktorClient.get(urlString = "planets/?page=$page").body()
    }

    override suspend fun getSpeciePage(page: Int): SpeciePageDto {
        return ktorClient.get(urlString = "species/?page=$page").body()
    }

    override suspend fun getStarshipPage(page: Int): StarshipPageDto {
        return ktorClient.get(urlString = "starships/?page=$page").body()
    }

    override suspend fun getVehiclePage(page: Int): VehiclePageDto {
        return ktorClient.get(urlString = "vehicles/?page=$page").body()
    }

}
