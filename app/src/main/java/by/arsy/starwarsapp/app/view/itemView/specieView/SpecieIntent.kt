package by.arsy.starwarsapp.app.view.itemView.specieView

sealed interface SpecieIntent {
    class GetPeople(val itemIdList: List<Int>) : SpecieIntent
    class GetFilms(val itemIdList: List<Int>) : SpecieIntent
}
