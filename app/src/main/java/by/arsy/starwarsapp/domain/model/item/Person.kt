package by.arsy.starwarsapp.domain.model.item

import java.time.Instant

data class Person(
    override val id: Int,
    override val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val homeworld: Int,
    val filmIdList: List<Int>,
    val specieIdList: List<Int>,
    val vehicleIdList: List<Int>,
    val starshipIdList: List<Int>,
    val created: Instant,
    val edited: Instant,
) : Item()
