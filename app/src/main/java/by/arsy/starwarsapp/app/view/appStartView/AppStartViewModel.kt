package by.arsy.starwarsapp.app.view.appStartView

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.arsy.starwarsapp.domain.model.item.Item
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
    private val getVehiclePageUseCase: GetVehiclePageUseCase
) : ViewModel() {

    private lateinit var itemType: ItemType
    private val _itemList = MutableStateFlow<List<Item>>(value = emptyList())
    val itemList = _itemList.asStateFlow()

    init {
        setItemType(itemType = ItemType.Person)
    }

    fun setItemType(itemType: ItemType) {
        this.itemType = itemType
        getItems(page = 1)
    }

    fun getCurrentItemTypeName(): String = itemType.name

    fun getItems(page: Int) {
        viewModelScope.launch(context = Dispatchers.IO) {
            try {
                _itemList.value = when (itemType) {
                    ItemType.Film -> getFilmPageUseCase.execute(page = page).results
                    ItemType.Person -> getPersonPageUseCase.execute(page = page).results
                    ItemType.Planet -> getPlanetPageUseCase.execute(page = page).results
                    ItemType.Specie -> getSpeciePageUseCase.execute(page = page).results
                    ItemType.Starship -> getStarshipPageUseCase.execute(page = page).results
                    ItemType.Vehicle -> getVehiclePageUseCase.execute(page = page).results
                }
            } catch (e: Exception) {
                Log.e("AppStartViewModel", e.message, e)
            }
        }
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



