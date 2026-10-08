package by.arsy.starwarsapp.domain.model.item

import java.time.Instant

data class Specie(
    override val id: Int,
    override val name: String,
    val classification: String,
    val designation: String,
    val averageHeight: String,
    val skinColors: String,
    val hairColors: String,
    val eyeColors: String,
    val averageLifespan: String,
    val homeworld: Int,
    val language: String,
    val personIdList: List<Int>,
    val filmIdList: List<Int>,
    val created: Instant,
    val edited: Instant,
) : Item()
