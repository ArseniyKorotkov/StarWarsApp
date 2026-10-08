package by.arsy.starwarsapp.domain.usecase.item

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.item.Planet

class GetPlanetUseCase(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(id: Int): Planet {
        return starWarsRepository.getPlanet(id = id)
    }

}
