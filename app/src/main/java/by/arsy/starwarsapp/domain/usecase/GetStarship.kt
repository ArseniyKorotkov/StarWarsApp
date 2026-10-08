package by.arsy.starwarsapp.domain.usecase

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.item.Starship

class GetStarship(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(id: Int): Starship {
        return starWarsRepository.getStarship(id = id)
    }

}
