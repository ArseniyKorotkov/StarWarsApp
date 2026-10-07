package by.arsy.starwarsapp.domain.usecase

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.Vehicle

class GetVehicle(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(id: Int): Vehicle {
        return starWarsRepository.getVehicle(id = id)
    }

}
