package by.arsy.starwarsapp.app.view.itemView.specieView

import androidx.lifecycle.ViewModel
import by.arsy.starwarsapp.app.view.itemView.getDetails
import by.arsy.starwarsapp.domain.usecase.item.GetFilmUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetPersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SpecieViewModel @Inject constructor(
    private val getPersonUseCase: GetPersonUseCase,
    private val getFilmUseCase: GetFilmUseCase,
) : ViewModel() {

    private val _specieState = MutableStateFlow(SpecieState())
    val specieState = _specieState.asStateFlow()

    fun handleIntent(intent: SpecieIntent) {
        when (intent) {
            is SpecieIntent.GetPeople -> getPeople(itemIdList = intent.itemIdList)
            is SpecieIntent.GetFilms -> getFilms(itemIdList = intent.itemIdList)
        }
    }

    private fun getPeople(itemIdList: List<Int>) {
        if (_specieState.value.personList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getPersonUseCase.execute(id = it) },
            onUpdateState = {
                _specieState.value = _specieState.value.copy(
                    personList = it,
                    isPersonListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

    private fun getFilms(itemIdList: List<Int>) {
        if (_specieState.value.filmList.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getFilmUseCase.execute(id = it) },
            onUpdateState = {
                _specieState.value = _specieState.value.copy(
                    filmList = it,
                    isFilmListLoadedState = it.size == itemIdList.size
                )
            }
        )
    }

}
