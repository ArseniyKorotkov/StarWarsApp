package by.arsy.starwarsapp.ui.screen.itemScreens.filmScreen

import androidx.lifecycle.ViewModel
import by.arsy.starwarsapp.domain.usecase.item.GetPersonUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetPlanetUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetSpecieUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetStarshipUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetVehicleUseCase
import by.arsy.starwarsapp.ui.screen.itemScreens.getDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    private val getPersonUseCase: GetPersonUseCase,
    private val getPlanetUseCase: GetPlanetUseCase,
    private val getStarshipUseCase: GetStarshipUseCase,
    private val getVehicleUseCase: GetVehicleUseCase,
    private val getSpecieUseCase: GetSpecieUseCase,
) : ViewModel() {

    private val _filmState = MutableStateFlow(FilmState())
    val filmState = _filmState.asStateFlow()

    fun handleIntent(intent: FilmIntent) {
        when (intent) {
            is FilmIntent.GetPeople -> getPeople(itemIdList = intent.itemIdList)
            is FilmIntent.GetPlanets -> getPlanets(itemIdList = intent.itemIdList)
            is FilmIntent.GetStarships -> getStarships(itemIdList = intent.itemIdList)
            is FilmIntent.GetVehicles -> getVehicles(itemIdList = intent.itemIdList)
            is FilmIntent.GetSpecies -> getSpecies(itemIdList = intent.itemIdList)
        }
    }

    private fun getPeople(itemIdList: List<Int>) {
        if (_filmState.value.personList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getPersonUseCase.execute(id = it) },
            onUpdateState = {
                _filmState.value = _filmState.value.copy(
                    personList = it,
                    isPersonListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

    private fun getPlanets(itemIdList: List<Int>) {
        if (_filmState.value.planetList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getPlanetUseCase.execute(id = it) },
            onUpdateState = {
                _filmState.value = _filmState.value.copy(
                    planetList = it,
                    isPlanetListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

    private fun getStarships(itemIdList: List<Int>) {
        if (_filmState.value.starshipList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getStarshipUseCase.execute(id = it) },
            onUpdateState = {
                _filmState.value = _filmState.value.copy(
                    starshipList = it,
                    isStarshipListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

    private fun getVehicles(itemIdList: List<Int>) {
        if (_filmState.value.vehicleList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getVehicleUseCase.execute(id = it) },
            onUpdateState = {
                _filmState.value = _filmState.value.copy(
                    vehicleList = it,
                    isVehicleListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

    private fun getSpecies(itemIdList: List<Int>) {
        if (_filmState.value.specieList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getSpecieUseCase.execute(id = it) },
            onUpdateState = {
                _filmState.value = _filmState.value.copy(
                    specieList = it,
                    isSpecieListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

}
