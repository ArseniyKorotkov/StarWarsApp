package by.arsy.starwarsapp.app.view.appStartView

import by.arsy.starwarsapp.domain.model.item.Item

data class AppStartState (
    val currentPage: List<Item> = emptyList(),
    val currentItem: Item? = null,
    val isCurrentItemLoaded: Boolean = false,
    val isCurrentPageLoaded: Boolean = false,
    val currentType: AppStartViewModel.ItemType = AppStartViewModel.ItemType.Film,
)