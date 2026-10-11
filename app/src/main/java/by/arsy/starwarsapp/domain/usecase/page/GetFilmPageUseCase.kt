package by.arsy.starwarsapp.domain.usecase.page

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.page.FilmPage

class GetFilmPageUseCase(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(pageNumber: Int): FilmPage {
        return starWarsRepository.getFilmPage(page = pageNumber)
    }

}