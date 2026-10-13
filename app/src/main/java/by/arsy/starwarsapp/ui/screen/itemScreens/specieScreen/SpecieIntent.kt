package by.arsy.starwarsapp.ui.screen.itemScreens.specieScreen

sealed interface SpecieIntent {
    class GetPeople(val itemIdList: List<Int>) : SpecieIntent
    class GetFilms(val itemIdList: List<Int>) : SpecieIntent
}
