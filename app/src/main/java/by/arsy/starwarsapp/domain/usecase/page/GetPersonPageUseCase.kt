package by.arsy.starwarsapp.domain.usecase.page

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.page.PersonPage

class GetPersonPageUseCase(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(pageNumber: Int): PersonPage {
        return starWarsRepository.getPersonPage(page = pageNumber)
    }

}