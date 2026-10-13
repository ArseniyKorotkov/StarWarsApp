package by.arsy.starwarsapp.ui.screen.itemScreens.personScreen

sealed interface PersonIntent {
    class GetFilms(val itemIdList: List<Int>) : PersonIntent
    class GetSpecies(val itemIdList: List<Int>) : PersonIntent
    class GetVehicles(val itemIdList: List<Int>) : PersonIntent
    class GetStarships(val itemIdList: List<Int>) : PersonIntent
}