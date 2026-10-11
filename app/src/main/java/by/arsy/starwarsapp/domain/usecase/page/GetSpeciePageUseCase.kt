package by.arsy.starwarsapp.domain.usecase.page

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.page.SpeciePage

class GetSpeciePageUseCase(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(pageNumber: Int): SpeciePage {
        return starWarsRepository.getSpeciePage(page = pageNumber)
    }

}
