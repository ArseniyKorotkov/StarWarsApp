package by.arsy.starwarsapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import by.arsy.starwarsapp.app.view.appStartView.AppStartIntent
import by.arsy.starwarsapp.app.view.appStartView.AppStartView
import by.arsy.starwarsapp.app.view.appStartView.AppStartViewModel
import by.arsy.starwarsapp.app.view.personView.Person
import by.arsy.starwarsapp.domain.model.item.Person
import by.arsy.starwarsapp.ui.theme.StarWarsAppTheme
import dagger.hilt.android.AndroidEntryPoint

const val ITEM_ID = "item_id"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val appStartViewModel: AppStartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val appStartState by appStartViewModel.appStartState.collectAsState()

            StarWarsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "startView"
                    ) {
                        composable("startView") {
                            AppStartView(
                                itemTypeList = AppStartViewModel.ItemType.entries.map { it.name },
                                onItemTypeClick = {
                                    val type = AppStartViewModel.ItemType.valueOf(it)
                                    appStartViewModel.handleIntent(
                                        AppStartIntent.DownloadPage(
                                            page = 1,
                                            type = type
                                        )
                                    )
                                },
                                itemIdList = appStartState.currentPage.map { it.id },
                                getItemName = { id ->
                                    appStartState.currentPage.first { it.id == id }.name
                                },
                                onItemNameClick = {
                                    val type = appStartState.currentType
                                    appStartViewModel.handleIntent(
                                        intent = AppStartIntent.DownloadItem(
                                            id = it,
                                            type = type
                                        )
                                    )
                                    navController.navigate(
                                        route = "${type.name}/$it"
                                    )
                                },
                                modifier = Modifier.padding(paddingValues = innerPadding)
                            )
                        }

                        composable(
                            route = "${AppStartViewModel.ItemType.Person.name}/{$ITEM_ID}",
                        ) {
                            if (appStartState.isCurrentItemLoaded) {
                                Person(
                                    person = appStartState.currentItem as Person,
                                    onFilmClick = {},
                                    onSpecieClick = {},
                                    viewModel = hiltViewModel(),
                                    modifier = Modifier.padding(paddingValues = innerPadding)
                                )
                            } else {
                                Text(
                                    text = "Loading...",
                                    modifier = Modifier.padding(paddingValues = innerPadding)
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}
