package by.arsy.starwarsapp.domain.usecase.page

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.page.StarshipPage

class GetStarshipPageUseCase(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(page: Int): StarshipPage {
        return starWarsRepository.getStarshipPage(page = page)
    }

}
