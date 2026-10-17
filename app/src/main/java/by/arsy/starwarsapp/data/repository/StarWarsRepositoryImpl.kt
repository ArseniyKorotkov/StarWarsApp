package by.arsy.starwarsapp.data.repository

import by.arsy.starwarsapp.data.repository.storage.StarWarsRemoteStorage
import by.arsy.starwarsapp.domain.StarWarsRepository
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StarWarsRepositoryImpl(
    private val starWarsRemoteStorage: StarWarsRemoteStorage
) : StarWarsRepository {

    override suspend fun getFilm(id: Int): Film = withContext(Dispatchers.Default) {
        starWarsRemoteStorage.getFilm(id = id).map()
    }

    override suspend fun getPerson(id: Int): Person = withContext(Dispatchers.Default) {
        starWarsRemoteStorage.getPerson(id = id).map()
    }

    override suspend fun getPlanet(id: Int): Planet = withContext(Dispatchers.Default) {
        starWarsRemoteStorage.getPlanet(id = id).map()
    }

    override suspend fun getSpecie(id: Int): Specie = withContext(Dispatchers.Default) {
        starWarsRemoteStorage.getSpecie(id = id).map()
    }

    override suspend fun getStarship(id: Int): Starship = withContext(Dispatchers.Default) {
        starWarsRemoteStorage.getStarship(id = id).map()
    }

    override suspend fun getVehicle(id: Int): Vehicle = withContext(Dispatchers.Default) {
        starWarsRemoteStorage.getVehicle(id = id).map()
    }

    override suspend fun getFilmPage(page: Int): FilmPage = withContext(Dispatchers.Default) {
        starWarsRemoteStorage.getFilmPage(page = page).map()
    }

    override suspend fun getPersonPage(page: Int): PersonPage = withContext(Dispatchers.Default) {
        starWarsRemoteStorage.getPersonPage(page = page).map()
    }

    override suspend fun getPlanetPage(page: Int): PlanetPage = withContext(Dispatchers.Default) {
        starWarsRemoteStorage.getPlanetPage(page = page).map()
    }

    override suspend fun getSpeciePage(page: Int): SpeciePage = withContext(Dispatchers.Default) {
        starWarsRemoteStorage.getSpeciePage(page = page).map()
    }

    override suspend fun getStarshipPage(page: Int): StarshipPage =
        withContext(Dispatchers.Default) {
            starWarsRemoteStorage.getStarshipPage(page = page).map()
        }

    override suspend fun getVehiclePage(page: Int): VehiclePage = withContext(Dispatchers.Default) {
        starWarsRemoteStorage.getVehiclePage(page = page).map()
    }

}