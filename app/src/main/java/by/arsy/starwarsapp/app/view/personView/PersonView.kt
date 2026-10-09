package by.arsy.starwarsapp.app.view.personView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import by.arsy.starwarsapp.app.component.Dropdown
import by.arsy.starwarsapp.domain.model.item.Person

@Composable
fun Person(
    person: Person,
    viewModel: PersonViewModel,
    onFilmClick: (Int) -> Unit,
    onSpecieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val rememberScrollState = rememberScrollState()
    val filmList by viewModel.filmList.collectAsState()
    val specieList by viewModel.specieList.collectAsState()

    Column(
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
            variables = person.filmIdList,
            variableText = { id -> filmList.firstOrNull{ it.id == id }?.name ?: "Loading..." },
            onClick = { onFilmClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Dropdown(
            header = "species",
            variables = person.specieIdList,
            variableText = { id -> specieList.firstOrNull{ it.id == id }?.name ?: "Loading..." },
            onClick = { onSpecieClick.invoke(it) },
            modifier = Modifier.fillMaxWidth()
        )

        Text(text = "filmIdList: ${person.filmIdList}")
        Text(text = "specieIdList: ${person.specieIdList}")
        Text(text = "vehicleIdList: ${person.vehicleIdList}")
        Text(text = "starshipIdList: ${person.starshipIdList}")
    }
}