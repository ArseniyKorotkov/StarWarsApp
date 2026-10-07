package by.arsy.starwarsapp.domain.usecase

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.Specie

class GetSpecie(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(id: Int): Specie {
        return starWarsRepository.getSpecie(id = id)
    }

}
