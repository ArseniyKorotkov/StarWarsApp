package by.arsy.starwarsapp.app.view.personView

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.arsy.starwarsapp.domain.model.item.Film
import by.arsy.starwarsapp.domain.model.item.Item
import by.arsy.starwarsapp.domain.model.item.Specie
import by.arsy.starwarsapp.domain.model.item.Starship
import by.arsy.starwarsapp.domain.model.item.Vehicle
import by.arsy.starwarsapp.domain.usecase.item.GetFilmUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetSpecieUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetStarshipUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetVehicleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val getFilmUseCase: GetFilmUseCase,
    private val getSpecieUseCase: GetSpecieUseCase,
    private val getVehicleUseCase: GetVehicleUseCase,
    private val getStarshipUseCase: GetStarshipUseCase,
) : ViewModel() {

    private val _personState = MutableStateFlow(PersonState())
    val personState = _personState.asStateFlow()

    fun handleIntent(intent: PersonIntent) {
        when (intent) {
            is PersonIntent.GetFilms -> getFilms(itemIdList = intent.itemIdList)
            is PersonIntent.GetSpecies -> getSpecies(itemIdList = intent.itemIdList)
            is PersonIntent.GetVehicles -> getVehicles(itemIdList = intent.itemIdList)
            is PersonIntent.GetStarships -> getStarships(itemIdList = intent.itemIdList)
        }
    }

    private fun getFilms(itemIdList: List<Int>) {
        if (_personState.value.filmList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getFilmUseCase.execute(id = it) },
            onUpdateState = {
                _personState.value = _personState.value.copy(
                    filmList = it as List<Film>,
                    isFilmListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

    private fun getSpecies(itemIdList: List<Int>) {
        if (_personState.value.specieList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getSpecieUseCase.execute(id = it) },
            onUpdateState = {
                _personState.value = _personState.value.copy(
                    specieList = it as List<Specie>,
                    isSpecieListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

    private fun getVehicles(itemIdList: List<Int>) {
        if (_personState.value.vehicleList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getVehicleUseCase.execute(id = it) },
            onUpdateState = {
                _personState.value = _personState.value.copy(
                    vehicleList = it as List<Vehicle>,
                    isVehicleListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

    private fun getStarships(itemIdList: List<Int>) {
        if (_personState.value.starshipList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getStarshipUseCase.execute(id = it) },
            onUpdateState = {
                _personState.value = _personState.value.copy(
                    starshipList = it as List<Starship>,
                    isStarshipListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

    private fun getDetails(
        detailIdList: List<Int>?,
        onGetDetail: suspend (Int) -> Item,
        onUpdateState: (List<Item>) -> Unit
    ) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val details = mutableListOf<Item>()
            detailIdList?.forEach {
                details.add(onGetDetail(it))
            }
            onUpdateState.invoke(details)
        }
    }


}