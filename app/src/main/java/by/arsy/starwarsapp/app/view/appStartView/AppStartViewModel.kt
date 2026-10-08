package by.arsy.starwarsapp.app.view.appStartView

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.model.item.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppStartViewModel @Inject constructor(
    private val repository: StarWarsRepository
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

    fun getItems(page: Int) {
        viewModelScope.launch(context = Dispatchers.IO) {
            try {
                _itemList.value = when (itemType) {
                    ItemType.Film -> repository.getFilmPage(page = page).results
                    ItemType.Person -> repository.getPersonPage(page = page).results
                    ItemType.Planet -> repository.getPlanetPage(page = page).results
                    ItemType.Specie -> repository.getSpeciePage(page = page).results
                    ItemType.Starship -> repository.getStarshipPage(page = page).results
                    ItemType.Vehicle -> repository.getVehiclePage(page = page).results
                }
            } catch (e : Exception) {
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



