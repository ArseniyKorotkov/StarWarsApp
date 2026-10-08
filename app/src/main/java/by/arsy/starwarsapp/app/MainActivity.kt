package by.arsy.starwarsapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import by.arsy.starwarsapp.app.view.appStartView.AppStartView
import by.arsy.starwarsapp.app.view.appStartView.AppStartViewModel
import by.arsy.starwarsapp.app.view.personView.PersonViewModel
import by.arsy.starwarsapp.ui.theme.StarWarsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val appStartViewModel: AppStartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val itemList by appStartViewModel.itemList.collectAsState()

            StarWarsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppStartView(
                        itemTypeList = AppStartViewModel.ItemType.entries.map { it.name },
                        onItemTypeClick = {
                            val type = AppStartViewModel.ItemType.valueOf(it)
                            appStartViewModel.setItemType(itemType = type)
                        },
                        itemIdList = itemList.map { it.id },
                        getItemName = { id -> itemList.first { it.id == id }.name },
                        onItemNameClick = {  },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
