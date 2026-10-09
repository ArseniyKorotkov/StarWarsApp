package by.arsy.starwarsapp.app.view.itemView.planetView

import androidx.lifecycle.ViewModel
import by.arsy.starwarsapp.app.view.itemView.getDetails
import by.arsy.starwarsapp.domain.usecase.item.GetFilmUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetPersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PlanetViewModel @Inject constructor(
    private val getPersonUseCase: GetPersonUseCase,
    private val getFilmUseCase: GetFilmUseCase,
) : ViewModel() {

    private val _planetState = MutableStateFlow(PlanetState())
    val planetState = _planetState.asStateFlow()

    fun handleIntent(intent: PlanetIntent) {
        when (intent) {
            is PlanetIntent.GetResidents -> getResidents(itemIdList = intent.itemIdList)
            is PlanetIntent.GetFilms -> getFilms(itemIdList = intent.itemIdList)
        }
    }

    private fun getResidents(itemIdList: List<Int>) {
        if (_planetState.value.residentList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getPersonUseCase.execute(id = it) },
            onUpdateState = {
                _planetState.value = _planetState.value.copy(
                    residentList = it,
                    isResidentListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

    private fun getFilms(itemIdList: List<Int>) {
        if (_planetState.value.filmList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getFilmUseCase.execute(id = it) },
            onUpdateState = {
                _planetState.value = _planetState.value.copy(
                    filmList = it,
                    isFilmListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

}
