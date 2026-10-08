package by.arsy.starwarsapp.data.dto.page

import by.arsy.starwarsapp.data.dto.item.SpecieDto
import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.page.SpeciePage
import kotlinx.serialization.Serializable

@Serializable
data class SpeciePageDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<SpecieDto>
) {
    fun map(): SpeciePage {
        return SpeciePage(
            count = this.count,
            next = this.next?.parseUslToId(),
            previous = this.previous?.parseUslToId(),
            results = this.results.map { it.map() }
        )
    }
}
