package by.arsy.starwarsapp.app.view.itemView.filmView

sealed interface FilmIntent {
    class GetPeople(val itemIdList: List<Int>) : FilmIntent
    class GetPlanets(val itemIdList: List<Int>) : FilmIntent
    class GetStarships(val itemIdList: List<Int>) : FilmIntent
    class GetVehicles(val itemIdList: List<Int>) : FilmIntent
    class GetSpecies(val itemIdList: List<Int>) : FilmIntent
}
