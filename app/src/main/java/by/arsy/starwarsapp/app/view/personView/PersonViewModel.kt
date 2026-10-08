package by.arsy.starwarsapp.app.view.personView

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.item.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val repository: StarWarsRepository
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
            _person.value = repository.getPerson(id = id)
        }
    }

    fun getFilmsCount() = _person.value?.filmIdList?.size

    fun getFilms() {
        getDetails(
            detailIdList = _person.value?.filmIdList,
            onGetDetail = { repository.getFilm(id = it).title },
            onUpdateState = { _filmList.value = it }
        )
    }

    fun getSpecies() {
        getDetails(
            detailIdList = _person.value?.specieIdList,
            onGetDetail = { repository.getSpecie(id = it).name },
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