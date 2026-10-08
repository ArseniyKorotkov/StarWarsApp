package by.arsy.starwarsapp.domain.usecase.item

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.item.Specie

class GetSpecieUseCase(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(id: Int): Specie {
        return starWarsRepository.getSpecie(id = id)
    }

}
