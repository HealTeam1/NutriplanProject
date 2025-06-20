package com.healtteam.nutriplanproject.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.healtteam.nutriplanproject.presentation.di.PresentationModule
import com.healtteam.nutriplanproject.presentation.view.PacientesScreen
import com.healtteam.nutriplanproject.presentation.view.PlanesScreen
import com.healtteam.nutriplanproject.presentation.view.PerfilScreen

@Composable
fun Home() {
    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem(
            icon = Icons.Default.List,
            title = "Pacientes",
            route = "pacientes"
        ),
        NavigationItem(
            icon = Icons.Default.Person,
            title = "Planes",
            route = "planes"
        )
    )

    val selectedIndex = remember { mutableStateOf(0) }

    val pacientesViewModel = PresentationModule.getPacientesViewModel()
    val planesViewModel = PresentationModule.getPlanesViewModel()
    val perfilViewModel = PresentationModule.getPerfilViewModel()

    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex.value == index,
                        icon = { Icon(item.icon, contentDescription = null) },
                        onClick = {
                            selectedIndex.value = index
                            navController.navigate(item.route)
                        },
                        label = { Text(item.title) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController,
            startDestination = "pacientes",
            modifier = Modifier.padding(padding)
        ) {
            composable("pacientes") {
                PacientesScreen(pacientesViewModel)
            }
            composable("planes") {
                PlanesScreen(planesViewModel)
            }
            composable("perfil") {
                PerfilScreen(perfilViewModel)
            }
        }
    }
}

data class NavigationItem(
    val icon: ImageVector,
    val title: String,
    val route: String
)