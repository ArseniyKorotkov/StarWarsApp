package by.arsy.starwarsapp.app.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.arsy.starwarsapp.R
import by.arsy.starwarsapp.app.view.appStartView.component.LoadingComponent

@Composable
fun Dropdown(
    header: String,
    variables: List<Int>,
    variableText: (Int) -> String,
    isLoadedState: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    onItemClick: (Int) -> Unit
) {

    var isExpanded by rememberSaveable { mutableStateOf(false) }
    val degrees by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f
    )

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClick.invoke()
                    isExpanded = !isExpanded
                }
        ) {
            Text(
                text = "$header: ${variables.size}",
                modifier = Modifier.weight(1f)
            )

            if (variables.isNotEmpty()) {
                Icon(
                    painter = painterResource(id = R.drawable.down_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .rotate(degrees)
                        .size(30.dp)
                )
            }
        }


        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp)
            ) {
                if (isLoadedState) {
                    variables.forEach {
                        Text(
                            text = variableText.invoke(it),
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable { onItemClick.invoke(it) }
                        )
                    }
                } else {
                    LoadingComponent()
                }
            }
        }
    }
}

@Preview
@Composable
private fun DropdownPreview() {
    Dropdown(
        header = "Drop me",
        variables = listOf(1, 2, 3),
        variableText = { "Number: $it" },
        isLoadedState = true,
        onItemClick = {}
    )
}
