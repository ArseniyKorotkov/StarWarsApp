package by.arsy.starwarsapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import by.arsy.starwarsapp.app.navigation.NavigationHost
import by.arsy.starwarsapp.app.view.appStartView.AppStartViewModel
import by.arsy.starwarsapp.ui.theme.StarWarsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        private const val START_DESTINATION = "startView"
    }

    val appStartViewModel: AppStartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val appStartState by appStartViewModel.appStartState.collectAsState()
            val currentRoute by navController.currentBackStackEntryAsState()

            StarWarsAppTheme {
                Scaffold(
                    floatingActionButton = {
                        AnimatedVisibility(
                            visible = currentRoute?.destination?.route != START_DESTINATION
                        ) {
                            Button(
                                onClick = { navController.navigate(route = START_DESTINATION) }
                            ) {
                                Text(text = "HOME")
                            }
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    NavigationHost(
                        startDestination = START_DESTINATION,
                        navController = navController,
                        appStartState = appStartState,
                        appStartViewModel = appStartViewModel,
                        modifier = Modifier
                            .padding(paddingValues = innerPadding)
                            .padding(horizontal = 8.dp)
                    )
                }
            }
        }
    }
}
