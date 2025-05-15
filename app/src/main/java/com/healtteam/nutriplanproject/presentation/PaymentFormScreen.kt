package com.healtteam.nutriplanproject.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentFormScreen(navController: NavController) {
    var ownerName by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }
    var expiryDate by remember { mutableStateOf("") }
    var cvc by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Formulario de Pago") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Regresar")
                    }
                }
            )
        }
    ) { paddingValues ->
        PaymentFormContent(
            paddingValues = paddingValues,
            ownerName = ownerName,
            onOwnerNameChange = { ownerName = it },
            cardNumber = cardNumber,
            onCardNumberChange = { cardNumber = it },
            expiryDate = expiryDate,
            onExpiryDateChange = { expiryDate = it },
            cvc = cvc,
            onCvcChange = { cvc = it },
            email = email,
            onEmailChange = { email = it },
            onConfirmClick = { navController.navigate("paymentConfirmation") }
        )
    }
}

@Composable
fun PaymentFormContent(
    paddingValues: PaddingValues,
    ownerName: String,
    onOwnerNameChange: (String) -> Unit,
    cardNumber: String,
    onCardNumberChange: (String) -> Unit,
    expiryDate: String,
    onExpiryDateChange: (String) -> Unit,
    cvc: String,
    onCvcChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    onConfirmClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PaymentTextField(
            value = ownerName,
            onValueChange = onOwnerNameChange,
            label = "Nombre del Propietario"
        )
        PaymentTextField(
            value = cardNumber,
            onValueChange = onCardNumberChange,
            label = "Número de Tarjeta"
        )
        PaymentTextField(
            value = expiryDate,
            onValueChange = onExpiryDateChange,
            label = "Fecha de Vencimiento"
        )
        PaymentTextField(
            value = cvc,
            onValueChange = onCvcChange,
            label = "CVC"
        )
        PaymentTextField(
            value = email,
            onValueChange = onEmailChange,
            label = "Correo Electrónico"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onConfirmClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirmar")
        }
    }
}

@Composable
fun PaymentTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
    )
}

