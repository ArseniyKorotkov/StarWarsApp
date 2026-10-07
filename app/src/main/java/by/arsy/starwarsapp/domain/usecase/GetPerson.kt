package by.arsy.starwarsapp.domain.usecase

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.Person

class GetPerson(private val starWarsRepository: StarWarsRepository) {

    suspend fun execute(id: Int): Person {
        return starWarsRepository.getPerson(id = id)
    }

}