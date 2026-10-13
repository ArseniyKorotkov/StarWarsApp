package by.arsy.starwarsapp.ui.screen.appStartScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import by.arsy.starwarsapp.ui.component.LoadingComponent

@Composable
fun AppStartScreen(
    itemTypeList: List<String>,
    onItemTypeClick: (String) -> Unit,
    itemIdList: List<Int>,
    getItemName: (Int) -> String,
    onItemNameClick: (Int) -> Unit,
    viewModel: AppStartViewModel,
    modifier: Modifier = Modifier
) {
    val appStartState by viewModel.appStartState.collectAsState()
    var searchText by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            placeholder = { Text(text = "Search...") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(itemTypeList) {
                Button(
                    onClick = { onItemTypeClick.invoke(it) },
                    modifier = Modifier.height(52.dp)
                ) {
                    Text(text = it)
                }
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(itemIdList) {
                val itemName = getItemName.invoke(it)
                if (itemName.contains(other = searchText, ignoreCase = true)) {
                    Text(
                        text = itemName,
                        modifier = Modifier.clickable { onItemNameClick.invoke(it) }
                    )
                }
            }

            item {
                LaunchedEffect(key1 = itemIdList.size) {
                    if (!appStartState.currentPageState.isPageLast) {
                        viewModel.handleIntent(AppStartIntent.DownloadNextPage)
                    }
                }
                if (!appStartState.currentPageState.isPageLast) {
                    LoadingComponent(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}