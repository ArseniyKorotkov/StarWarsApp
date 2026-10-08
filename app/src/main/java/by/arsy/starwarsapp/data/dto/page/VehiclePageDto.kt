package by.arsy.starwarsapp.data.dto.page

import by.arsy.starwarsapp.data.dto.item.VehicleDto
import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.page.VehiclePage
import kotlinx.serialization.Serializable

@Serializable
data class VehiclePageDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<VehicleDto>
) {
    fun map(): VehiclePage {
        return VehiclePage(
            count = this.count,
            next = this.next?.parseUslToId(),
            previous = this.previous?.parseUslToId(),
            results = this.results.map { it.map() }
        )
    }
}
