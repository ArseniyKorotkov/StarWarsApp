package by.arsy.starwarsapp.ui.screen.itemScreens.planetScreen

sealed interface PlanetIntent {
    class GetResidents(val itemIdList: List<Int>) : PlanetIntent
    class GetFilms(val itemIdList: List<Int>) : PlanetIntent
}
