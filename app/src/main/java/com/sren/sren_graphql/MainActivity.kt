package com.sren.sren_graphql

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sren.sren_graphql.ui.screen.character_detail.CharacterScreen
import com.sren.sren_graphql.ui.screen.character_list.CharacterListScreen
import com.sren.sren_graphql.ui.theme.SrenGraphQLTheme
import com.sren.sren_graphql.ui.util.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SrenGraphQLTheme {
                val navController = rememberNavController()
                
                NavHost(navController = navController, startDestination = Route.characterList) {
                    composable(Route.characterList) {
                        CharacterListScreen(
                            onCharacterClick = {id ->
                                navController.navigate(
                                    Route.character.replace("{id}", id)
                                )
                            }
                        )
                    }

                    composable(Route.character) {
                        CharacterScreen(
                            navigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}



