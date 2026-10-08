package by.arsy.starwarsapp.data.dto.page

import by.arsy.starwarsapp.data.dto.item.PlanetDto
import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.page.PlanetPage
import kotlinx.serialization.Serializable

@Serializable
data class PlanetPageDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PlanetDto>
) {
    fun map(): PlanetPage {
        return PlanetPage(
            count = this.count,
            next = this.next?.parseUslToId(),
            previous = this.previous?.parseUslToId(),
            results = this.results.map { it.map() }
        )
    }
}
