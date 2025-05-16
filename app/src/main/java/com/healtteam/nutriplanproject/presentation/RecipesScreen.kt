package com.healtteam.nutriplanproject.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecipesScreen() {

    val totalDays = 30
    val currentDay = 15
    val targetWeight = 65
    val currentWeight = 70
    val targetFat = 15
    val currentWater = 1.5f
    val dailyWaterGoal = 2.0f
    val currentActivity = 30
    val dailyActivityGoal = 60

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(0.9f),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Objetivo",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Text(
                        text = "Día $currentDay de $totalDays",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Peso Objetivo: $targetWeight kg",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Peso Actual: $currentWeight kg",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = (currentWeight - targetWeight).coerceAtLeast(0) / currentWeight.toFloat(),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Grasa Objetivo: $targetFat%",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = currentDay / totalDays.toFloat(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }


        Card(
            modifier = Modifier.fillMaxWidth(0.9f),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Resumen Diario",
                    style = MaterialTheme.typography.headlineSmall
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Progreso de agua
                Text(
                    text = "Consumo de Agua: ${currentWater}L / ${dailyWaterGoal}L",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = currentWater / dailyWaterGoal,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))


                Text(
                    text = "Actividad Física: $currentActivity min / $dailyActivityGoal min",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = currentActivity / dailyActivityGoal.toFloat(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}