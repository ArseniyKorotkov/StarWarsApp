package by.arsy.starwarsapp.domain.usecase.item

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.item.Vehicle

class GetVehicleUseCase(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(id: Int): Vehicle {
        return starWarsRepository.getVehicle(id = id)
    }

}
