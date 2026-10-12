package by.arsy.starwarsapp.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import by.arsy.starwarsapp.app.view.appStartView.AppStartIntent
import by.arsy.starwarsapp.app.view.appStartView.AppStartScreen
import by.arsy.starwarsapp.app.view.appStartView.AppStartState
import by.arsy.starwarsapp.app.view.appStartView.AppStartViewModel
import by.arsy.starwarsapp.app.view.appStartView.component.LoadingComponent
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

@Composable
fun NavigationHost(
    startDestination: String,
    navController: NavHostController,
    appStartState: AppStartState,
    appStartViewModel: AppStartViewModel,
    modifier: Modifier = Modifier
) {
    val navId = "itemId"

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = startDestination) {
            AppStartScreen(
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
                        appStartViewModel = appStartViewModel,
                        type = appStartState.currentPageType,
                        navController = navController
                    )
                },
                viewModel = appStartViewModel,
                modifier = modifier
            )
        }

        composable(
            route = "${AppStartViewModel.ItemType.Film.name}/{$navId}",
        ) {
            val isCurrent = appStartState.itemBackStack.lastOrNull() is Film
            if (appStartState.isCurrentItemLoaded && isCurrent) {
                FilmScreen(
                    film = appStartState.itemBackStack.last() as Film,
                    onPersonClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Person,
                            navController = navController
                        )
                    },
                    onPlanetClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Planet,
                            navController = navController
                        )
                    },
                    onStarshipClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Starship,
                            navController = navController
                        )
                    },
                    onVehicleClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Vehicle,
                            navController = navController
                        )
                    },
                    onSpecieClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Specie,
                            navController = navController
                        )
                    },
                    viewModel = hiltViewModel(),
                    onBackClick = {
                        appStartViewModel.handleIntent(intent = AppStartIntent.PopItemTypeBackStack)
                        navController.popBackStack()
                    },
                    modifier = modifier
                )
            } else {
                LoadingComponent(modifier = Modifier.fillMaxSize())
            }
        }

        composable(
            route = "${AppStartViewModel.ItemType.Person.name}/{$navId}",
        ) {
            val isCurrent = appStartState.itemBackStack.lastOrNull() is Person
            if (appStartState.isCurrentItemLoaded && isCurrent) {
                PersonScreen(
                    person = appStartState.itemBackStack.last() as Person,
                    onFilmClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Film,
                            navController = navController
                        )
                    },
                    onSpecieClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Specie,
                            navController = navController
                        )
                    },
                    onVehicleClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Specie,
                            navController = navController
                        )
                    },
                    onStarshipClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Specie,
                            navController = navController
                        )
                    },
                    viewModel = hiltViewModel(),
                    onBackClick = {
                        appStartViewModel.handleIntent(intent = AppStartIntent.PopItemTypeBackStack)
                        navController.popBackStack()
                    },
                    modifier = modifier
                )
            } else {
                LoadingComponent(modifier = Modifier.fillMaxSize())
            }
        }

        composable(
            route = "${AppStartViewModel.ItemType.Planet.name}/{$navId}"
        ) {
            val isCurrent = appStartState.itemBackStack.lastOrNull() is Planet
            if (appStartState.isCurrentItemLoaded && isCurrent) {
                PlanetScreen(
                    planet = appStartState.itemBackStack.last() as Planet,
                    onResidentClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Person,
                            navController = navController
                        )
                    },
                    onFilmClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Film,
                            navController = navController
                        )
                    },
                    viewModel = hiltViewModel(),
                    onBackClick = {
                        appStartViewModel.handleIntent(intent = AppStartIntent.PopItemTypeBackStack)
                        navController.popBackStack()
                    },
                    modifier = modifier
                )
            } else {
                LoadingComponent(modifier = Modifier.fillMaxSize())
            }
        }

        composable(
            route = "${AppStartViewModel.ItemType.Specie.name}/{$navId}"
        ) {
            val isCurrent = appStartState.itemBackStack.lastOrNull() is Specie
            if (appStartState.isCurrentItemLoaded && isCurrent) {
                SpecieScreen(
                    specie = appStartState.itemBackStack.last() as Specie,
                    onPersonClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Person,
                            navController = navController
                        )
                    },
                    onFilmClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Film,
                            navController = navController
                        )
                    },
                    viewModel = hiltViewModel(),
                    onBackClick = {
                        appStartViewModel.handleIntent(intent = AppStartIntent.PopItemTypeBackStack)
                        navController.popBackStack()
                    },
                    modifier = modifier
                )
            } else {
                LoadingComponent(modifier = Modifier.fillMaxSize())
            }
        }

        composable(
            route = "${AppStartViewModel.ItemType.Starship.name}/{$navId}"
        ) {
            val isCurrent = appStartState.itemBackStack.lastOrNull() is Starship
            if (appStartState.isCurrentItemLoaded && isCurrent) {
                StarshipScreen(
                    starship = appStartState.itemBackStack.last() as Starship,
                    onPilotClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Person,
                            navController = navController
                        )
                    },
                    onFilmClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Film,
                            navController = navController
                        )
                    },
                    viewModel = hiltViewModel(),
                    onBackClick = {
                        appStartViewModel.handleIntent(intent = AppStartIntent.PopItemTypeBackStack)
                        navController.popBackStack()
                    },
                    modifier = modifier
                )
            } else {
                LoadingComponent(modifier = Modifier.fillMaxSize())
            }
        }

        composable(
            route = "${AppStartViewModel.ItemType.Vehicle.name}/{$navId}"
        ) {
            val isCurrent = appStartState.itemBackStack.lastOrNull() is Vehicle
            if (appStartState.isCurrentItemLoaded && isCurrent) {
                VehicleScreen(
                    vehicle = appStartState.itemBackStack.last() as Vehicle,
                    onPilotClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Person,
                            navController = navController
                        )
                    },
                    onFilmClick = {
                        navigateItem(
                            id = it,
                            appStartViewModel = appStartViewModel,
                            type = AppStartViewModel.ItemType.Film,
                            navController = navController
                        )
                    },
                    viewModel = hiltViewModel(),
                    onBackClick = {
                        appStartViewModel.handleIntent(intent = AppStartIntent.PopItemTypeBackStack)
                        navController.popBackStack()
                    },
                    modifier = modifier
                )
            } else {
                LoadingComponent(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
private fun navigateItem(
    id: Int,
    appStartViewModel: AppStartViewModel,
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