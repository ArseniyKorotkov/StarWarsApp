package by.arsy.starwarsapp.data.dto.page

import by.arsy.starwarsapp.data.dto.item.StarshipDto
import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.page.StarshipPage
import kotlinx.serialization.Serializable

@Serializable
data class StarshipPageDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<StarshipDto>
) {
    fun map(): StarshipPage {
        return StarshipPage(
            count = this.count,
            next = this.next?.parseUslToId(),
            previous = this.previous?.parseUslToId(),
            results = this.results.map { it.map() }
        )
    }
}
