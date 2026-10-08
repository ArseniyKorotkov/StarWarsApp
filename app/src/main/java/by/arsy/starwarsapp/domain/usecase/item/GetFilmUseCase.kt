package by.arsy.starwarsapp.domain.usecase.item

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.item.Film

class GetFilmUseCase(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(id: Int): Film {
        return starWarsRepository.getFilm(id = id)
    }

}