package by.arsy.starwarsapp.domain.usecase.page

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.page.VehiclePage

class GetVehiclePageUseCase(
    private val starWarsRepository: StarWarsRepository
) {

    suspend fun execute(page: Int): VehiclePage {
        return starWarsRepository.getVehiclePage(page = page)
    }

}
