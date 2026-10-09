package by.arsy.starwarsapp.app.view.itemView.starshipView

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
import by.arsy.starwarsapp.domain.model.item.Starship

@Composable
fun StarshipScreen(
    starship: Starship,
    viewModel: StarshipViewModel,
    modifier: Modifier = Modifier,
    onPilotClick: (Int) -> Unit = {},
    onFilmClick: (Int) -> Unit = {}
) {
    val rememberScrollState = rememberScrollState()
    val starshipState by viewModel.starshipState.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.verticalScroll(rememberScrollState)
    ) {
        Text(text = "name: ${starship.name}")
        Text(text = "model: ${starship.model}")
        Text(text = "manufacturer: ${starship.manufacturer}")
        Text(text = "costInCredits: ${starship.costInCredits}")
        Text(text = "length: ${starship.length}")
        Text(text = "maxAtmospheringSpeed: ${starship.maxAtmospheringSpeed}")
        Text(text = "crew: ${starship.crew}")
        Text(text = "passengers: ${starship.passengers}")
        Text(text = "cargoCapacity: ${starship.cargoCapacity}")
        Text(text = "consumables: ${starship.consumables}")
        Text(text = "hyperdriveRating: ${starship.hyperdriveRating}")
        Text(text = "MGLT: ${starship.MGLT}")
        Text(text = "starshipClass: ${starship.starshipClass}")

        Dropdown(
            header = "pilots",
            onClick = {
                viewModel.handleIntent(StarshipIntent.GetPilots(itemIdList = starship.pilotIdList))
            },
            variables = starship.pilotIdList,
            variableText = { id -> starshipState.pilotList.first { it.id == id }.name },
            isLoadedState = starshipState.isPilotListLoadedState,
            onItemClick = { onPilotClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Dropdown(
            header = "films",
            onClick = {
                viewModel.handleIntent(StarshipIntent.GetFilms(itemIdList = starship.filmIdList))
            },
            variables = starship.filmIdList,
            variableText = { id -> starshipState.filmList.first { it.id == id }.name },
            isLoadedState = starshipState.isFilmListLoadedState,
            onItemClick = { onFilmClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
