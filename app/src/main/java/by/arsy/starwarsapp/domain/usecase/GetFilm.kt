package by.arsy.starwarsapp.domain.usecase

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.item.Film

class GetFilm(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(id: Int): Film {
        return starWarsRepository.getFilm(id = id)
    }

}