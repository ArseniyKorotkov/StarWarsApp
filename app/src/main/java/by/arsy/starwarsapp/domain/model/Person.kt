package by.arsy.starwarsapp.domain.model

import java.time.Instant

data class Person (
    val id: Int,
    val name: String,
    val height: Int,
    val mass: Int,
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
)