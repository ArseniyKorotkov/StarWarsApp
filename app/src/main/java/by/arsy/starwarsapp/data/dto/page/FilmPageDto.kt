package by.arsy.starwarsapp.data.dto.page

import by.arsy.starwarsapp.data.dto.item.FilmDto
import by.arsy.starwarsapp.data.util.parseUslToId
import by.arsy.starwarsapp.domain.model.page.FilmPage
import kotlinx.serialization.Serializable

@Serializable
data class FilmPageDto(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<FilmDto>
) {
    fun map(): FilmPage {
        return FilmPage(
            count = this.count,
            next = this.next?.parseUslToId(),
            previous = this.previous?.parseUslToId(),
            results = this.results.map { it.map() }
        )
    }
}