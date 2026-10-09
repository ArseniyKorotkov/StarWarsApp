package by.arsy.starwarsapp.app.view.itemView.specieView

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
import by.arsy.starwarsapp.domain.model.item.Specie

@Composable
fun SpecieScreen(
    specie: Specie,
    viewModel: SpecieViewModel,
    modifier: Modifier = Modifier,
    onPersonClick: (Int) -> Unit = {},
    onFilmClick: (Int) -> Unit = {}
) {
    val rememberScrollState = rememberScrollState()
    val specieState by viewModel.specieState.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.verticalScroll(rememberScrollState)
    ) {
        Text(text = "name: ${specie.name}")
        Text(text = "classification: ${specie.classification}")
        Text(text = "designation: ${specie.designation}")
        Text(text = "averageHeight: ${specie.averageHeight}")
        Text(text = "skinColors: ${specie.skinColors}")
        Text(text = "hairColors: ${specie.hairColors}")
        Text(text = "eyeColors: ${specie.eyeColors}")
        Text(text = "averageLifespan: ${specie.averageLifespan}")
        Text(text = "homeworld: ${specie.homeworld}")
        Text(text = "language: ${specie.language}")

        Dropdown(
            header = "people",
            onClick = {
                viewModel.handleIntent(SpecieIntent.GetPeople(itemIdList = specie.personIdList))
            },
            variables = specie.personIdList,
            variableText = { id -> specieState.personList.first { it.id == id }.name },
            isLoadedState = specieState.isPersonListLoadedState,
            onItemClick = { onPersonClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Dropdown(
            header = "films",
            onClick = {
                viewModel.handleIntent(SpecieIntent.GetFilms(itemIdList = specie.filmIdList))
            },
            variables = specie.filmIdList,
            variableText = { id -> specieState.filmList.first { it.id == id }.name },
            isLoadedState = specieState.isFilmListLoadedState,
            onItemClick = { onFilmClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
