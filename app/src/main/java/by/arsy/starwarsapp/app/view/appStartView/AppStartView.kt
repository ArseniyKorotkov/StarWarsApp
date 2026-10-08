package by.arsy.starwarsapp.app.view.appStartView

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppStartView(
    itemTypeList: List<String>,
    onItemTypeClick: (String) -> Unit,
    itemIdList: List<Int>,
    getItemName: (Int) -> String,
    onItemNameClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
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

        LazyColumn {
            items(itemIdList) {
                Text(
                    text = getItemName.invoke(it),
                    modifier = Modifier.clickable { onItemNameClick.invoke(it) }
                )
            }
        }
    }
}