package by.arsy.starwarsapp.domain.usecase.page

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.page.PlanetPage

class GetPlanetPageUseCase(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(pageNumber: Int): PlanetPage {
        return starWarsRepository.getPlanetPage(page = pageNumber)
    }

}
