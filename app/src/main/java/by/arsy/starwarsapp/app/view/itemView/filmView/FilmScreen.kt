package by.arsy.starwarsapp.app.view.itemView.filmView

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import by.arsy.starwarsapp.app.component.Dropdown
import by.arsy.starwarsapp.domain.model.item.Film

@Composable
fun FilmScreen(
    film: Film,
    viewModel: FilmViewModel,
    modifier: Modifier = Modifier,
    onPersonClick: (Int) -> Unit = {},
    onPlanetClick: (Int) -> Unit = {},
    onStarshipClick: (Int) -> Unit = {},
    onVehicleClick: (Int) -> Unit = {},
    onSpecieClick: (Int) -> Unit = {},
    onBackClick: () -> Unit
) {
    val rememberScrollState = rememberScrollState()
    val filmState by viewModel.filmState.collectAsState()

    BackHandler(enabled = true) {
        onBackClick.invoke()
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.verticalScroll(rememberScrollState)
    ) {
        Text(text = "title: ${film.title}")
        Text(text = "episodeId: ${film.episodeId}")
        Text(text = "openingCrawl: ${film.openingCrawl}")
        Text(text = "director: ${film.director}")
        Text(text = "producer: ${film.producer}")
        Text(text = "releaseDate: ${film.releaseDate}")

        Dropdown(
            header = "characters",
            onClick = {
                viewModel.handleIntent(FilmIntent.GetPeople(itemIdList = film.characters))
            },
            variables = film.characters,
            variableText = { id -> filmState.personList.first { it.id == id }.name },
            isLoadedState = filmState.isPersonListLoadedState,
            onItemClick = { onPersonClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Dropdown(
            header = "planets",
            onClick = {
                viewModel.handleIntent(FilmIntent.GetPlanets(itemIdList = film.planetIdList))
            },
            variables = film.planetIdList,
            variableText = { id -> filmState.planetList.first { it.id == id }.name },
            isLoadedState = filmState.isPlanetListLoadedState,
            onItemClick = { onPlanetClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Dropdown(
            header = "starships",
            onClick = {
                viewModel.handleIntent(FilmIntent.GetStarships(itemIdList = film.starshipIdList))
            },
            variables = film.starshipIdList,
            variableText = { id -> filmState.starshipList.first { it.id == id }.name },
            isLoadedState = filmState.isStarshipListLoadedState,
            onItemClick = { onStarshipClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Dropdown(
            header = "vehicles",
            onClick = {
                viewModel.handleIntent(FilmIntent.GetVehicles(itemIdList = film.vehicleIdList))
            },
            variables = film.vehicleIdList,
            variableText = { id -> filmState.vehicleList.first { it.id == id }.name },
            isLoadedState = filmState.isVehicleListLoadedState,
            onItemClick = { onVehicleClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Dropdown(
            header = "species",
            onClick = {
                viewModel.handleIntent(FilmIntent.GetSpecies(itemIdList = film.specieIdList))
            },
            variables = film.specieIdList,
            variableText = { id -> filmState.specieList.first { it.id == id }.name },
            isLoadedState = filmState.isSpecieListLoadedState,
            onItemClick = { onSpecieClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
