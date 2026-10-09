package by.arsy.starwarsapp.app.view.personView

sealed interface PersonIntent {
    class GetFilms(val itemIdList: List<Int>) : PersonIntent
    class GetSpecies(val itemIdList: List<Int>) : PersonIntent
    class GetVehicles(val itemIdList: List<Int>) : PersonIntent
    class GetStarships(val itemIdList: List<Int>) : PersonIntent
}