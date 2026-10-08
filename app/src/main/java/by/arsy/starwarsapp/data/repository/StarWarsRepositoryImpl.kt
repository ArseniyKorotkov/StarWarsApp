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

    override suspend fun getFilmPage(page: Int): FilmPage =
        starWarsRemoteStorage.getFilmPage(page = page).map()

    override suspend fun getPersonPage(page: Int): PersonPage =
        starWarsRemoteStorage.getPersonPage(page = page).map()

    override suspend fun getPlanetPage(page: Int): PlanetPage =
        starWarsRemoteStorage.getPlanetPage(page = page).map()

    override suspend fun getSpeciePage(page: Int): SpeciePage =
        starWarsRemoteStorage.getSpeciePage(page = page).map()

    override suspend fun getStarshipPage(page: Int): StarshipPage =
        starWarsRemoteStorage.getStarshipPage(page = page).map()

    override suspend fun getVehiclePage(page: Int): VehiclePage =
        starWarsRemoteStorage.getVehiclePage(page = page).map()

}