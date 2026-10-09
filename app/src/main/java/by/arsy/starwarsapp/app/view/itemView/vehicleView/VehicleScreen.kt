package by.arsy.starwarsapp.app.view.itemView.vehicleView

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
import by.arsy.starwarsapp.domain.model.item.Vehicle

@Composable
fun VehicleScreen(
    vehicle: Vehicle,
    viewModel: VehicleViewModel,
    modifier: Modifier = Modifier,
    onPilotClick: (Int) -> Unit = {},
    onFilmClick: (Int) -> Unit = {}
) {
    val rememberScrollState = rememberScrollState()
    val vehicleState by viewModel.vehicleState.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.verticalScroll(rememberScrollState)
    ) {
        Text(text = "name: ${vehicle.name}")
        Text(text = "model: ${vehicle.model}")
        Text(text = "manufacturer: ${vehicle.manufacturer}")
        Text(text = "costInCredits: ${vehicle.costInCredits}")
        Text(text = "length: ${vehicle.length}")
        Text(text = "maxAtmospheringSpeed: ${vehicle.maxAtmospheringSpeed}")
        Text(text = "crew: ${vehicle.crew}")
        Text(text = "passengers: ${vehicle.passengers}")
        Text(text = "cargoCapacity: ${vehicle.cargoCapacity}")
        Text(text = "consumables: ${vehicle.consumables}")
        Text(text = "vehicleClass: ${vehicle.vehicleClass}")

        Dropdown(
            header = "pilots",
            onClick = {
                viewModel.handleIntent(VehicleIntent.GetPilots(itemIdList = vehicle.pilotIdList))
            },
            variables = vehicle.pilotIdList,
            variableText = { id -> vehicleState.pilotList.first { it.id == id }.name },
            isLoadedState = vehicleState.isPilotListLoadedState,
            onItemClick = { onPilotClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Dropdown(
            header = "films",
            onClick = {
                viewModel.handleIntent(VehicleIntent.GetFilms(itemIdList = vehicle.filmIdList))
            },
            variables = vehicle.filmIdList,
            variableText = { id -> vehicleState.filmList.first { it.id == id }.name },
            isLoadedState = vehicleState.isFilmListLoadedState,
            onItemClick = { onFilmClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
