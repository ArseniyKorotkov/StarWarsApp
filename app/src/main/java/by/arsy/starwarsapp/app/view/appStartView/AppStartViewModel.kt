package by.arsy.starwarsapp.app.view.appStartView

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.arsy.starwarsapp.domain.usecase.item.GetFilmUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetPersonUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetPlanetUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetSpecieUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetStarshipUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetVehicleUseCase
import by.arsy.starwarsapp.domain.usecase.page.GetFilmPageUseCase
import by.arsy.starwarsapp.domain.usecase.page.GetPersonPageUseCase
import by.arsy.starwarsapp.domain.usecase.page.GetPlanetPageUseCase
import by.arsy.starwarsapp.domain.usecase.page.GetSpeciePageUseCase
import by.arsy.starwarsapp.domain.usecase.page.GetStarshipPageUseCase
import by.arsy.starwarsapp.domain.usecase.page.GetVehiclePageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppStartViewModel @Inject constructor(
    private val getFilmPageUseCase: GetFilmPageUseCase,
    private val getPersonPageUseCase: GetPersonPageUseCase,
    private val getPlanetPageUseCase: GetPlanetPageUseCase,
    private val getSpeciePageUseCase: GetSpeciePageUseCase,
    private val getStarshipPageUseCase: GetStarshipPageUseCase,
    private val getVehiclePageUseCase: GetVehiclePageUseCase,
    private val getFilmUseCase: GetFilmUseCase,
    private val getPersonUseCase: GetPersonUseCase,
    private val getPlanetUseCase: GetPlanetUseCase,
    private val getSpecieUseCase: GetSpecieUseCase,
    private val getStarshipUseCase: GetStarshipUseCase,
    private val getVehicleUseCase: GetVehicleUseCase
) : ViewModel() {

    private val _appStartState = MutableStateFlow(AppStartState())

    val appStartState = _appStartState.asStateFlow()

    init {
        handleIntent(
            intent = AppStartIntent.DownloadNextPage
        )
    }

    fun handleIntent(intent: AppStartIntent) {
        when (intent) {
            is AppStartIntent.DownloadItem -> downloadItem(
                itemId = intent.id,
                type = intent.type
            )
            is AppStartIntent.DownloadNextPage -> {
                downloadNextPageItems()
            }

            is AppStartIntent.OpenPage -> openPage(type = intent.type)

            AppStartIntent.PopItemTypeBackStack -> _appStartState.value.itemBackStack.removeLastOrNull()
        }
    }

    private fun downloadItem(
        itemId: Int,
        type: ItemType
    ) {
        _appStartState.value = _appStartState.value.copy(
            isCurrentItemLoaded = false
        )

        viewModelScope.launch(context = Dispatchers.IO) {
            val item = when (type) {
                ItemType.Film -> getFilmUseCase.execute(id = itemId)
                ItemType.Person -> getPersonUseCase.execute(id = itemId)
                ItemType.Planet -> getPlanetUseCase.execute(id = itemId)
                ItemType.Specie -> getSpecieUseCase.execute(id = itemId)
                ItemType.Starship -> getStarshipUseCase.execute(id = itemId)
                ItemType.Vehicle -> getVehicleUseCase.execute(id = itemId)
            }

            _appStartState.value.itemBackStack.add(item)
            _appStartState.value = _appStartState.value.copy(
                isCurrentItemLoaded = true
            )
        }
    }

    private fun downloadNextPageItems() {
        _appStartState.value = _appStartState.value.copy(
            isCurrentPageLoaded = false
        )

        viewModelScope.launch(context = Dispatchers.IO) {
            try {
                when (_appStartState.value.currentPageType) {
                    ItemType.Film -> {
                        val pageState = _appStartState.value.filmPageState
                        if (pageState.isPageLast) return@launch
                        val nextPageNumber = pageState.pageNumber + 1
                        val page = getFilmPageUseCase.execute(pageNumber = nextPageNumber)
                        val newState = PageState(
                            items = pageState.items + page.results,
                            pageNumber = nextPageNumber,
                            isPageLast = page.next == null
                        )
                        _appStartState.value = _appStartState.value.copy(
                            filmPageState = newState,
                            currentPageState = newState,
                        )
                    }
                    ItemType.Person -> {
                        val pageState = _appStartState.value.personPageState
                        if (pageState.isPageLast) return@launch
                        val nextPageNumber = pageState.pageNumber + 1
                        val page = getPersonPageUseCase.execute(pageNumber = nextPageNumber)
                        val newState = PageState(
                            items = pageState.items + page.results,
                            pageNumber = nextPageNumber,
                            isPageLast = page.next == null
                        )
                        _appStartState.value = _appStartState.value.copy(
                            personPageState = newState,
                            currentPageState = newState,
                        )
                    }
                    ItemType.Planet -> {
                        val pageState = _appStartState.value.planetPageState
                        if (pageState.isPageLast) return@launch
                        val nextPageNumber = pageState.pageNumber + 1
                        val page = getPlanetPageUseCase.execute(pageNumber = nextPageNumber)
                        val newState = PageState(
                            items = pageState.items + page.results,
                            pageNumber = nextPageNumber,
                            isPageLast = page.next == null
                        )
                        _appStartState.value = _appStartState.value.copy(
                            planetPageState = newState,
                            currentPageState = newState,
                        )
                    }
                    ItemType.Specie -> {
                        val pageState = _appStartState.value.speciePageState
                        if (pageState.isPageLast) return@launch
                        val nextPageNumber = pageState.pageNumber + 1
                        val page = getSpeciePageUseCase.execute(pageNumber = nextPageNumber)
                        val newState = PageState(
                            items = pageState.items + page.results,
                            pageNumber = nextPageNumber,
                            isPageLast = page.next == null
                        )
                        _appStartState.value = _appStartState.value.copy(
                            speciePageState = newState,
                            currentPageState = newState,
                        )
                    }
                    ItemType.Starship -> {
                        val pageState = _appStartState.value.starshipPageState
                        if (pageState.isPageLast) return@launch
                        val nextPageNumber = pageState.pageNumber + 1
                        val page = getStarshipPageUseCase.execute(pageNumber = nextPageNumber)
                        val newState = PageState(
                            items = pageState.items + page.results,
                            pageNumber = nextPageNumber,
                            isPageLast = page.next == null
                        )
                        _appStartState.value = _appStartState.value.copy(
                            starshipPageState = newState,
                            currentPageState = newState,
                        )
                    }
                    ItemType.Vehicle -> {
                        val pageState = _appStartState.value.vehiclePageState
                        if (pageState.isPageLast) return@launch
                        val nextPageNumber = pageState.pageNumber + 1
                        val page = getVehiclePageUseCase.execute(pageNumber = nextPageNumber)
                        val newState = PageState(
                            items = pageState.items + page.results,
                            pageNumber = nextPageNumber,
                            isPageLast = page.next == null
                        )
                        _appStartState.value = _appStartState.value.copy(
                            vehiclePageState = newState,
                            currentPageState = newState,
                        )
                    }
                }
            } catch (e: Exception) {
                Log.e("AppStartViewModel", e.message, e)
            }
        }
    }

    private fun openPage(
        type: ItemType
    ) {
        val currentPage =  when(type) {
            ItemType.Film -> _appStartState.value.filmPageState
            ItemType.Person -> _appStartState.value.personPageState
            ItemType.Planet -> _appStartState.value.planetPageState
            ItemType.Specie -> _appStartState.value.speciePageState
            ItemType.Starship -> _appStartState.value.starshipPageState
            ItemType.Vehicle -> _appStartState.value.vehiclePageState
        }
        _appStartState.value = _appStartState.value.copy(
            currentPageType = type,
            currentPageState = currentPage,
        )
    }


    enum class ItemType {
        Film,
        Person,
        Planet,
        Specie,
        Starship,
        Vehicle,
    }
}



