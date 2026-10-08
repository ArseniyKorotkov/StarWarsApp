package by.arsy.starwarsapp.app.view.personView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import by.arsy.starwarsapp.app.component.Dropdown
import by.arsy.starwarsapp.domain.model.item.Person

@Composable
fun Person(
    person: Person,
    viewModel: PersonViewModel,
    modifier: Modifier = Modifier
) {
    val rememberScrollState = rememberScrollState()

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
            variableText = { "" },
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "filmIdList: ${person.filmIdList}")
        Text(text = "specieIdList: ${person.specieIdList}")
        Text(text = "vehicleIdList: ${person.vehicleIdList}")
        Text(text = "starshipIdList: ${person.starshipIdList}")
    }
}