package by.arsy.starwarsapp.app.view.personView

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.arsy.starwarsapp.domain.model.item.Person
import by.arsy.starwarsapp.domain.usecase.item.GetFilmUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetPersonUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetSpecieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val getPersonUseCase: GetPersonUseCase,
    private val getFilmUseCase: GetFilmUseCase,
    private val getSpecieUseCase: GetSpecieUseCase
) : ViewModel() {

    private val _person: MutableStateFlow<Person?> = MutableStateFlow(null)
    private val person = _person.asStateFlow()
    private val _filmList: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    private val filmList = _filmList.asStateFlow()
    private val _specieList: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    private val specieList = _specieList.asStateFlow()

    init {
        getPerson(id = 1)
    }


    fun getPerson(id: Int) {
        viewModelScope.launch(context = Dispatchers.IO) {
            _person.value = getPersonUseCase.execute(id = id)
        }
    }

    fun getFilmsCount() = _person.value?.filmIdList?.size

    fun getFilms() {
        getDetails(
            detailIdList = _person.value?.filmIdList,
            onGetDetail = { getFilmUseCase.execute(id = it).title },
            onUpdateState = { _filmList.value = it }
        )
    }

    fun getSpecies() {
        getDetails(
            detailIdList = _person.value?.specieIdList,
            onGetDetail = { getSpecieUseCase.execute(id = it).name },
            onUpdateState = { _specieList.value = it }
        )
    }

    private fun getDetails(
        detailIdList: List<Int>?,
        onGetDetail: suspend (Int) -> String,
        onUpdateState: (List<String>) -> Unit
    ) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val details = mutableListOf<String>()
            detailIdList?.forEach {
                details.add(onGetDetail(it))
            }
            onUpdateState.invoke(details)
        }
    }


}