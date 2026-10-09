package by.arsy.starwarsapp.app.view.itemView.planetView

sealed interface PlanetIntent {
    class GetResidents(val itemIdList: List<Int>) : PlanetIntent
    class GetFilms(val itemIdList: List<Int>) : PlanetIntent
}
