package com.healtteam.nutriplanproject.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PaymentPlansScreen(navController: NavController) {
    var showPaymentDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Planes de Pago",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {  },
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Plan Free", style = MaterialTheme.typography.titleMedium)
                Text("Beneficios: Acceso limitado a funcionalidades básicas.")
            }
        }

        // Plan Premium
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable { showPaymentDialog = true },
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Plan Premium", style = MaterialTheme.typography.titleMedium)
                Text("Beneficios: Acceso completo a todas las funcionalidades.")
            }
        }
    }

    if (showPaymentDialog) {
        PaymentFormDialog(
            onDismiss = { showPaymentDialog = false },
            onConfirm = {
                showPaymentDialog = false
                navController.navigate("paymentConfirmation")
            }
        )
    }
}
