package by.arsy.starwarsapp.ui.screen.itemScreens.vehicleScreen

import androidx.lifecycle.ViewModel
import by.arsy.starwarsapp.domain.usecase.item.GetFilmUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetPersonUseCase
import by.arsy.starwarsapp.ui.screen.itemScreens.getDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(
    private val getPersonUseCase: GetPersonUseCase,
    private val getFilmUseCase: GetFilmUseCase,
) : ViewModel() {

    private val _vehicleState = MutableStateFlow(VehicleState())
    val vehicleState = _vehicleState.asStateFlow()

    fun handleIntent(intent: VehicleIntent) {
        when (intent) {
            is VehicleIntent.GetPilots -> getPilots(itemIdList = intent.itemIdList)
            is VehicleIntent.GetFilms -> getFilms(itemIdList = intent.itemIdList)
        }
    }

    private fun getPilots(itemIdList: List<Int>) {
        if (_vehicleState.value.pilotList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getPersonUseCase.execute(id = it) },
            onUpdateState = {
                _vehicleState.value = _vehicleState.value.copy(
                    pilotList = it,
                    isPilotListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

    private fun getFilms(itemIdList: List<Int>) {
        if (_vehicleState.value.filmList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getFilmUseCase.execute(id = it) },
            onUpdateState = {
                _vehicleState.value = _vehicleState.value.copy(
                    filmList = it,
                    isFilmListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

}
