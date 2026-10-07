package by.arsy.starwarsapp.data.repository.storage

import by.arsy.starwarsapp.data.dto.FilmDto
import by.arsy.starwarsapp.data.dto.PersonDto
import by.arsy.starwarsapp.data.dto.PlanetDto
import by.arsy.starwarsapp.data.dto.SpecieDto
import by.arsy.starwarsapp.data.dto.StarshipDto
import by.arsy.starwarsapp.data.dto.VehicleDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders

class StarWarsRemoteStorage : StarWarsStorage {

    val ktorClient = HttpClient {
        defaultRequest {
            url("https://swapi.dev")
            header(HttpHeaders.ContentType, ContentType.Application.Json)
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
}