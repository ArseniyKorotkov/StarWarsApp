package by.arsy.starwarsapp.ui.screen.itemScreens.planetScreen

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
import by.arsy.starwarsapp.ui.component.Dropdown
import by.arsy.starwarsapp.domain.model.item.Planet

@Composable
fun PlanetScreen(
    planet: Planet,
    viewModel: PlanetViewModel,
    modifier: Modifier = Modifier,
    onResidentClick: (Int) -> Unit = {},
    onFilmClick: (Int) -> Unit = {},
    onBackClick: () -> Unit
) {
    val rememberScrollState = rememberScrollState()
    val planetState by viewModel.planetState.collectAsState()

    BackHandler(enabled = true) {
        onBackClick.invoke()
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.verticalScroll(rememberScrollState)
    ) {
        Text(text = "name: ${planet.name}")
        Text(text = "rotationPeriod: ${planet.rotationPeriod}")
        Text(text = "orbitalPeriod: ${planet.orbitalPeriod}")
        Text(text = "diameter: ${planet.diameter}")
        Text(text = "climate: ${planet.climate}")
        Text(text = "gravity: ${planet.gravity}")
        Text(text = "terrain: ${planet.terrain}")
        Text(text = "surfaceWater: ${planet.surfaceWater}")
        Text(text = "population: ${planet.population}")

        Dropdown(
            header = "residents",
            onClick = {
                viewModel.handleIntent(PlanetIntent.GetResidents(itemIdList = planet.residentIdList))
            },
            variables = planet.residentIdList,
            variableText = { id -> planetState.residentList.first { it.id == id }.name },
            isLoadedState = planetState.isResidentListLoadedState,
            onItemClick = { onResidentClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Dropdown(
            header = "films",
            onClick = {
                viewModel.handleIntent(PlanetIntent.GetFilms(itemIdList = planet.filmIdList))
            },
            variables = planet.filmIdList,
            variableText = { id -> planetState.filmList.first { it.id == id }.name },
            isLoadedState = planetState.isFilmListLoadedState,
            onItemClick = { onFilmClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
