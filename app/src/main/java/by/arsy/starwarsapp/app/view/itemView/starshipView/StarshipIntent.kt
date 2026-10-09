package by.arsy.starwarsapp.app.view.itemView.starshipView

sealed interface StarshipIntent {
    class GetPilots(val itemIdList: List<Int>) : StarshipIntent
    class GetFilms(val itemIdList: List<Int>) : StarshipIntent
}
