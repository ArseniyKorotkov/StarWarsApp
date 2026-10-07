package by.arsy.starwarsapp.data.repository

import by.arsy.starwarsapp.data.repository.storage.StarWarsRemoteStorage
import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.Film
import by.arsy.starwarsapp.domain.model.Person
import by.arsy.starwarsapp.domain.model.Planet
import by.arsy.starwarsapp.domain.model.Specie
import by.arsy.starwarsapp.domain.model.Starship
import by.arsy.starwarsapp.domain.model.Vehicle

class StarWarsRepositoryImpl(
    private val starWarsRemoteStorage: StarWarsRemoteStorage
) : StarWarsRepository {

    override suspend fun getFilm(id: Int): Film =
        starWarsRemoteStorage.getFilm(id = id).map()

    override suspend fun getPerson(id: Int): Person =
        starWarsRemoteStorage.getPerson(id = id).map()

    override suspend fun getPlanet(id: Int): Planet =
        starWarsRemoteStorage.getPlanet(id = id).map()

    override suspend fun getSpecie(id: Int): Specie =
        starWarsRemoteStorage.getSpecie(id = id).map()

    override suspend fun getStarship(id: Int): Starship =
        starWarsRemoteStorage.getStarship(id = id).map()

    override suspend fun getVehicle(id: Int): Vehicle =
        starWarsRemoteStorage.getVehicle(id = id).map()

}