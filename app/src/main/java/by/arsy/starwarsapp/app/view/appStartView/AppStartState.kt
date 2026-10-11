package by.arsy.starwarsapp.app.view.appStartView

import by.arsy.starwarsapp.domain.model.item.Film
import by.arsy.starwarsapp.domain.model.item.Item
import by.arsy.starwarsapp.domain.model.item.Person
import by.arsy.starwarsapp.domain.model.item.Planet
import by.arsy.starwarsapp.domain.model.item.Specie
import by.arsy.starwarsapp.domain.model.item.Starship
import by.arsy.starwarsapp.domain.model.item.Vehicle

data class AppStartState(
    val itemBackStack: MutableList<Item> = mutableListOf(),
    val isCurrentItemLoaded: Boolean = false,
    val isCurrentPageLoaded: Boolean = false,
    val currentPageType: AppStartViewModel.ItemType = AppStartViewModel.ItemType.Film,
    val filmPageState: PageState<Film> = PageState(),
    val personPageState: PageState<Person> = PageState(),
    val planetPageState: PageState<Planet> = PageState(),
    val speciePageState: PageState<Specie> = PageState(),
    val starshipPageState: PageState<Starship> = PageState(),
    val vehiclePageState: PageState<Vehicle> = PageState(),
    val currentPageState: PageState<out Item> = when(currentPageType) {
        AppStartViewModel.ItemType.Film -> filmPageState
        AppStartViewModel.ItemType.Person -> personPageState
        AppStartViewModel.ItemType.Planet -> planetPageState
        AppStartViewModel.ItemType.Specie -> speciePageState
        AppStartViewModel.ItemType.Starship -> starshipPageState
        AppStartViewModel.ItemType.Vehicle -> vehiclePageState
    },
)

data class PageState<T : Item>(
    val items: List<T> = emptyList<T>(),
    val pageNumber: Int = 0,
    val isPageLast: Boolean = false
)