package by.arsy.starwarsapp.ui.screen.itemScreens.starshipScreen

import androidx.lifecycle.ViewModel
import by.arsy.starwarsapp.domain.usecase.item.GetFilmUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetPersonUseCase
import by.arsy.starwarsapp.ui.screen.itemScreens.getDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StarshipViewModel @Inject constructor(
    private val getPersonUseCase: GetPersonUseCase,
    private val getFilmUseCase: GetFilmUseCase,
) : ViewModel() {

    private val _starshipState = MutableStateFlow(StarshipState())
    val starshipState = _starshipState.asStateFlow()

    fun handleIntent(intent: StarshipIntent) {
        when (intent) {
            is StarshipIntent.GetPilots -> getPilots(itemIdList = intent.itemIdList)
            is StarshipIntent.GetFilms -> getFilms(itemIdList = intent.itemIdList)
        }
    }

    private fun getPilots(itemIdList: List<Int>) {
        if (_starshipState.value.pilotList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getPersonUseCase.execute(id = it) },
            onUpdateState = {
                _starshipState.value = _starshipState.value.copy(
                    pilotList = it,
                    isPilotListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

    private fun getFilms(itemIdList: List<Int>) {
        if (_starshipState.value.filmList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getFilmUseCase.execute(id = it) },
            onUpdateState = {
                _starshipState.value = _starshipState.value.copy(
                    filmList = it,
                    isFilmListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

}
