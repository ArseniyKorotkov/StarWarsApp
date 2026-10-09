package by.arsy.starwarsapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import by.arsy.starwarsapp.app.view.appStartView.AppStartView
import by.arsy.starwarsapp.app.view.appStartView.AppStartViewModel
import by.arsy.starwarsapp.app.view.personView.Person
import by.arsy.starwarsapp.domain.model.item.Person
import by.arsy.starwarsapp.ui.theme.StarWarsAppTheme
import dagger.hilt.android.AndroidEntryPoint

const val ITEM_ID = "item_id"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val appStartViewModel: AppStartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val itemList by appStartViewModel.itemList.collectAsState()

            StarWarsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "startView"
                    ) {
                        composable("startView") {
                            AppStartView(
                                itemTypeList = AppStartViewModel.ItemType.entries.map { it.name },
                                onItemTypeClick = {
                                    val type = AppStartViewModel.ItemType.valueOf(it)
                                    appStartViewModel.setItemType(itemType = type)
                                },
                                itemIdList = itemList.map { it.id },
                                getItemName = { id -> itemList.first { it.id == id }.name },
                                onItemNameClick = {
                                    navController.navigate(
                                        route = "${appStartViewModel.getCurrentItemTypeName()}/$it"
                                    )
                                },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        composable(
                            route = "${AppStartViewModel.ItemType.Person.name}/{$ITEM_ID}",
                            arguments = listOf(navArgument(name = ITEM_ID) {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val itemId = backStackEntry.arguments?.getString(/* key = */ ITEM_ID)!!

                            Person(
                                person = itemList.first { it.id == itemId.toInt() } as Person,
                                onFilmClick = {},
                                onSpecieClick = {},
                                viewModel = hiltViewModel()
                            )
                        }
                    }

                }
            }
        }
    }
}
