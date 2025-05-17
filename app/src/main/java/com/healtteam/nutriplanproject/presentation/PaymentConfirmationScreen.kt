package com.healtteam.nutriplanproject.presentation


import androidx.compose.runtime.Composable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.navigation.NavController



@Composable
fun PaymentConfirmationScreen(navController: NavController) {
    AlertDialog(
        onDismissRequest = { navController.popBackStack() },
        title = { Text("Confirmar Pago") },
        text = { Text("¿Deseas confirmar el pago?") },
        confirmButton = {
            TextButton(onClick = {  navController.popBackStack() }) {
                Text("Aceptar")
            }
        },
        dismissButton = {
            TextButton(onClick = { navController.popBackStack() }) {
                Text("Cancelar")
            }
        }
    )
}
