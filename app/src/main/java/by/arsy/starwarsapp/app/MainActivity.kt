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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import by.arsy.starwarsapp.app.view.appStartView.AppStartIntent
import by.arsy.starwarsapp.app.view.appStartView.AppStartView
import by.arsy.starwarsapp.app.view.appStartView.AppStartViewModel
import by.arsy.starwarsapp.app.view.itemView.filmView.FilmScreen
import by.arsy.starwarsapp.app.view.itemView.personView.PersonScreen
import by.arsy.starwarsapp.app.view.itemView.planetView.PlanetScreen
import by.arsy.starwarsapp.app.view.itemView.specieView.SpecieScreen
import by.arsy.starwarsapp.app.view.itemView.starshipView.StarshipScreen
import by.arsy.starwarsapp.app.view.itemView.vehicleView.VehicleScreen
import by.arsy.starwarsapp.domain.model.item.Film
import by.arsy.starwarsapp.domain.model.item.Person
import by.arsy.starwarsapp.domain.model.item.Planet
import by.arsy.starwarsapp.domain.model.item.Specie
import by.arsy.starwarsapp.domain.model.item.Starship
import by.arsy.starwarsapp.domain.model.item.Vehicle
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
                                        AppStartIntent.OpenPage(
                                            type = type
                                        )
                                    )
                                },
                                itemIdList = appStartState.currentPageState.items.map { it.id },
                                getItemName = { id ->
                                    appStartState.currentPageState.items.first { it.id == id }.name
                                },
                                onItemNameClick = {
                                    navigateItem(
                                        id = it,
                                        type = appStartState.currentPageType,
                                        navController = navController
                                    )
                                },
                                viewModel = appStartViewModel,
                                modifier = Modifier.padding(paddingValues = innerPadding)
                            )
                        }

                        composable(
                            route = "${AppStartViewModel.ItemType.Film.name}/{$ITEM_ID}",
                        ) {
                            val isCurrent = appStartState.itemBackStack.lastOrNull() is Film
                            if (appStartState.isCurrentItemLoaded && isCurrent) {
                                FilmScreen(
                                    film = appStartState.itemBackStack.last() as Film,
                                    onPersonClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Person,
                                            navController = navController
                                        )
                                    },
                                    onPlanetClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Planet,
                                            navController = navController
                                        )
                                    },
                                    onStarshipClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Starship,
                                            navController = navController
                                        )
                                    },
                                    onVehicleClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Vehicle,
                                            navController = navController
                                        )
                                    },
                                    onSpecieClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Specie,
                                            navController = navController
                                        )
                                    },
                                    viewModel = hiltViewModel(),
                                    onBackClick = {
                                        appStartViewModel.handleIntent(intent = AppStartIntent.PopItemTypeBackStack)
                                        navController.popBackStack()
                                    },
                                    modifier = Modifier.padding(paddingValues = innerPadding)
                                )
                            } else {
                                Text(
                                    text = "Loading...",
                                    modifier = Modifier.padding(paddingValues = innerPadding)
                                )
                            }
                        }

                        composable(
                            route = "${AppStartViewModel.ItemType.Person.name}/{$ITEM_ID}",
                        ) {
                            val isCurrent = appStartState.itemBackStack.lastOrNull() is Person
                            if (appStartState.isCurrentItemLoaded && isCurrent) {
                                PersonScreen(
                                    person = appStartState.itemBackStack.last() as Person,
                                    onFilmClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Film,
                                            navController = navController
                                        )
                                    },
                                    onSpecieClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Specie,
                                            navController = navController
                                        )
                                    },
                                    onVehicleClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Specie,
                                            navController = navController
                                        )
                                    },
                                    onStarshipClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Specie,
                                            navController = navController
                                        )
                                    },
                                    viewModel = hiltViewModel(),
                                    onBackClick = {
                                        appStartViewModel.handleIntent(intent = AppStartIntent.PopItemTypeBackStack)
                                        navController.popBackStack()
                                    },
                                    modifier = Modifier.padding(paddingValues = innerPadding)
                                )
                            } else {
                                Text(
                                    text = "Loading...",
                                    modifier = Modifier.padding(paddingValues = innerPadding)
                                )
                            }
                        }

                        composable(
                            route = "${AppStartViewModel.ItemType.Planet.name}/{$ITEM_ID}"
                        ) {
                            val isCurrent = appStartState.itemBackStack.lastOrNull() is Planet
                            if (appStartState.isCurrentItemLoaded && isCurrent) {
                                PlanetScreen(
                                    planet = appStartState.itemBackStack.last() as Planet,
                                    onResidentClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Person,
                                            navController = navController
                                        )
                                    },
                                    onFilmClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Film,
                                            navController = navController
                                        )
                                    },
                                    viewModel = hiltViewModel(),
                                    onBackClick = {
                                        appStartViewModel.handleIntent(intent = AppStartIntent.PopItemTypeBackStack)
                                        navController.popBackStack()
                                    },
                                    modifier = Modifier.padding(paddingValues = innerPadding)
                                )
                            } else {
                                Text(
                                    text = "Loading...",
                                    modifier = Modifier.padding(paddingValues = innerPadding)
                                )
                            }
                        }

                        composable(
                            route = "${AppStartViewModel.ItemType.Specie.name}/{$ITEM_ID}"
                        ) {
                            val isCurrent = appStartState.itemBackStack.lastOrNull() is Specie
                            if (appStartState.isCurrentItemLoaded && isCurrent) {
                                SpecieScreen(
                                    specie = appStartState.itemBackStack.last() as Specie,
                                    onPersonClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Person,
                                            navController = navController
                                        )
                                    },
                                    onFilmClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Film,
                                            navController = navController
                                        )
                                    },
                                    viewModel = hiltViewModel(),
                                    onBackClick = {
                                        appStartViewModel.handleIntent(intent = AppStartIntent.PopItemTypeBackStack)
                                        navController.popBackStack()
                                    },
                                    modifier = Modifier.padding(paddingValues = innerPadding)
                                )
                            } else {
                                Text(
                                    text = "Loading...",
                                    modifier = Modifier.padding(paddingValues = innerPadding)
                                )
                            }
                        }

                        composable(
                            route = "${AppStartViewModel.ItemType.Starship.name}/{$ITEM_ID}"
                        ) {
                            val isCurrent = appStartState.itemBackStack.lastOrNull() is Starship
                            if (appStartState.isCurrentItemLoaded && isCurrent) {
                                StarshipScreen(
                                    starship = appStartState.itemBackStack.last() as Starship,
                                    onPilotClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Person,
                                            navController = navController
                                        )
                                    },
                                    onFilmClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Film,
                                            navController = navController
                                        )
                                    },
                                    viewModel = hiltViewModel(),
                                    onBackClick = {
                                        appStartViewModel.handleIntent(intent = AppStartIntent.PopItemTypeBackStack)
                                        navController.popBackStack()
                                    },
                                    modifier = Modifier.padding(paddingValues = innerPadding)
                                )
                            } else {
                                Text(
                                    text = "Loading...",
                                    modifier = Modifier.padding(paddingValues = innerPadding)
                                )
                            }
                        }

                        composable(
                            route = "${AppStartViewModel.ItemType.Vehicle.name}/{$ITEM_ID}"
                        ) {
                            val isCurrent = appStartState.itemBackStack.lastOrNull() is Vehicle
                            if (appStartState.isCurrentItemLoaded && isCurrent) {
                                VehicleScreen(
                                    vehicle = appStartState.itemBackStack.last() as Vehicle,
                                    onPilotClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Person,
                                            navController = navController
                                        )
                                    },
                                    onFilmClick = {
                                        navigateItem(
                                            id = it,
                                            type = AppStartViewModel.ItemType.Film,
                                            navController = navController
                                        )
                                    },
                                    viewModel = hiltViewModel(),
                                    onBackClick = {
                                        appStartViewModel.handleIntent(intent = AppStartIntent.PopItemTypeBackStack)
                                        navController.popBackStack()
                                    },
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

    fun navigateItem(
        id: Int,
        type: AppStartViewModel.ItemType,
        navController: NavHostController
    ) {
        appStartViewModel.handleIntent(
            intent = AppStartIntent.DownloadItem(
                id = id,
                type = type
            )
        )
        navController.navigate(
            route = "${type.name}/$id"
        )
    }
}
