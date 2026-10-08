package by.arsy.starwarsapp.data.dto.page

import by.arsy.starwarsapp.data.dto.item.PersonDto
import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.page.PersonPage
import kotlinx.serialization.Serializable

@Serializable
data class PersonPageDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PersonDto>
) {
    fun map(): PersonPage {
        return PersonPage(
            count = this.count,
            next = this.next.takeIf { !it.isNullOrBlank() }?.parseUslToId(),
            previous = this.previous.takeIf { !it.isNullOrBlank() }?.parseUslToId(),
            results = this.results.map { it.map() }
        )
    }
}
