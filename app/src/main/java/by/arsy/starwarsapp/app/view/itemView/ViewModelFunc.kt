package by.arsy.starwarsapp.app.view.itemView

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.arsy.starwarsapp.domain.model.item.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

fun <T : Item> ViewModel.getDetails(
    detailIdList: List<Int>?,
    onGetDetail: suspend (Int) -> T,
    onUpdateState: (List<T>) -> Unit
) {
    viewModelScope.launch(Dispatchers.IO) {
        val details = detailIdList?.map {
           async { onGetDetail(it)}
        }?.awaitAll() ?: emptyList()

        onUpdateState(details)
    }
}