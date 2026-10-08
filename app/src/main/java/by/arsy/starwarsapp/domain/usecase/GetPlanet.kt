package by.arsy.starwarsapp.domain.usecase

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.item.Planet

class GetPlanet(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(id: Int): Planet {
        return starWarsRepository.getPlanet(id = id)
    }

}
