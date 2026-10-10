package by.arsy.starwarsapp.app.view.appStartView

import by.arsy.starwarsapp.domain.model.item.Item

data class AppStartState (
    val currentPage: List<Item> = emptyList(),
    val itemBackStack: MutableList<Item> = mutableListOf(),
    val isCurrentItemLoaded: Boolean = false,
    val isCurrentPageLoaded: Boolean = false,
    val currentPageType: AppStartViewModel.ItemType = AppStartViewModel.ItemType.Film,
)