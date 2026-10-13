package by.arsy.starwarsapp.ui.screen.itemScreens.starshipScreen

sealed interface StarshipIntent {
    class GetPilots(val itemIdList: List<Int>) : StarshipIntent
    class GetFilms(val itemIdList: List<Int>) : StarshipIntent
}
