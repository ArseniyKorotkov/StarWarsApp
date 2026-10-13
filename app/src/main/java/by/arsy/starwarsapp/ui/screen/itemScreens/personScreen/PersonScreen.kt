package by.arsy.starwarsapp.ui.screen.itemScreens.personScreen

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
import by.arsy.starwarsapp.domain.model.item.Person

@Composable
fun PersonScreen(
    person: Person,
    viewModel: PersonViewModel,
    modifier: Modifier = Modifier,
    onFilmClick: (Int) -> Unit = {},
    onSpecieClick: (Int) -> Unit = {},
    onVehicleClick: (Int) -> Unit = {},
    onStarshipClick: (Int) -> Unit = {},
    onBackClick: () -> Unit
) {
    val rememberScrollState = rememberScrollState()
    val personState by viewModel.personState.collectAsState()

    BackHandler(enabled = true) {
        onBackClick.invoke()
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.verticalScroll(rememberScrollState)
    ) {
        Text(text = "name: ${person.name}")
        Text(text = "height: ${person.height}")
        Text(text = "mass: ${person.mass}")
        Text(text = "hairColor: ${person.hairColor}")
        Text(text = "skinColor: ${person.skinColor}")
        Text(text = "eyeColor: ${person.eyeColor}")
        Text(text = "birthYear: ${person.birthYear}")
        Text(text = "gender: ${person.gender}")
        Text(text = "homeworld: ${person.homeworld}")

        Dropdown(
            header = "films",
            onClick = {
                viewModel.handleIntent(PersonIntent.GetFilms(itemIdList = person.filmIdList))
            },
            variables = person.filmIdList,
            variableText = { id -> personState.filmList.first { it.id == id }.name },
            isLoadedState = personState.isFilmListLoadedState,
            onItemClick = { onFilmClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Dropdown(
            header = "species",
            onClick = {
                viewModel.handleIntent(PersonIntent.GetSpecies(itemIdList = person.specieIdList))
            },
            variables = person.specieIdList,
            variableText = { id -> personState.specieList.first { it.id == id }.name },
            isLoadedState = personState.isSpecieListLoadedState,
            onItemClick = { onSpecieClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Dropdown(
            header = "vehicles",
            onClick = {
                viewModel.handleIntent(PersonIntent.GetVehicles(itemIdList = person.vehicleIdList))
            },
            variables = person.vehicleIdList,
            variableText = { id -> personState.vehicleList.first { it.id == id }.name },
            isLoadedState = personState.isVehicleListLoadedState,
            onItemClick = { onVehicleClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Dropdown(
            header = "starships",
            onClick = {
                viewModel.handleIntent(PersonIntent.GetStarships(itemIdList = person.starshipIdList))
            },
            variables = person.starshipIdList,
            variableText = { id -> personState.starshipList.first { it.id == id }.name },
            isLoadedState = personState.isStarshipListLoadedState,
            onItemClick = { onStarshipClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

    }
}
