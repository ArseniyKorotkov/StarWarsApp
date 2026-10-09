package by.arsy.starwarsapp.app.view.personView

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.arsy.starwarsapp.domain.model.item.Film
import by.arsy.starwarsapp.domain.model.item.Item
import by.arsy.starwarsapp.domain.model.item.Specie
import by.arsy.starwarsapp.domain.usecase.item.GetFilmUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetSpecieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    private val getFilmUseCase: GetFilmUseCase,
    private val getSpecieUseCase: GetSpecieUseCase
) : ViewModel() {

    private val _filmList: MutableStateFlow<List<Film>> = MutableStateFlow(emptyList())
    val filmList = _filmList.asStateFlow()
    private val _specieList: MutableStateFlow<List<Specie>> = MutableStateFlow(emptyList())
    val specieList = _specieList.asStateFlow()
    private val _isFilmListLoadedState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isFilmListLoadedState = _isFilmListLoadedState.asStateFlow()
    private val _isSpecieListLoadedState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isSpecieListLoadedState = _isSpecieListLoadedState.asStateFlow()


    fun getFilms(itemIdList: List<Int>) {
        if (_filmList.value.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getFilmUseCase.execute(id = it) },
            onUpdateState = {
                _filmList.value = it as List<Film>
                _isFilmListLoadedState.value = it.size == itemIdList.size
            }
        )
    }

    fun getSpecies(itemIdList: List<Int>) {
        if (_specieList.value.size == itemIdList.size) return
        getDetails(
            detailIdList = itemIdList,
            onGetDetail = { getSpecieUseCase.execute(id = it) },
            onUpdateState = {
                _specieList.value = it as List<Specie>
                _isSpecieListLoadedState.value = it.size == itemIdList.size
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