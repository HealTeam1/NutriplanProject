package com.healtteam.nutriplanproject.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
    var showEditDialog by remember { mutableStateOf(false) }
    var showSubscriptionDialog by remember { mutableStateOf(false) }
    var showDeleteConfirmation by remember { mutableStateOf(false) }


    var name by remember { mutableStateOf("Juan Pérez") }
    var email by remember { mutableStateOf("juan.perez@example.com") }
    var birthDate by remember { mutableStateOf("01/01/1990") }
    var weight by remember { mutableStateOf("70 kg") }
    var height by remember { mutableStateOf("1.75 m") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Perfil",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))


        Text("Nombre: $name", style = MaterialTheme.typography.bodyLarge)
        Text("Correo Electrónico: $email", style = MaterialTheme.typography.bodyLarge)
        Text("Fecha de Nacimiento: $birthDate", style = MaterialTheme.typography.bodyLarge)
        Text("Peso: $weight", style = MaterialTheme.typography.bodyLarge)
        Text("Altura: $height", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(32.dp))


        Button(
            onClick = { showEditDialog = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Editar Perfil")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { showSubscriptionDialog = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Estado de Suscripción")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { showDeleteConfirmation = true },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
        ) {
            Text("Eliminar Perfil")
        }
    }


    if (showEditDialog) {
        EditProfileDialog(
            name = name,
            onNameChange = { name = it },
            email = email,
            onEmailChange = { email = it },
            birthDate = birthDate,
            onBirthDateChange = { birthDate = it },
            weight = weight,
            onWeightChange = { weight = it },
            height = height,
            onHeightChange = { height = it },
            onDismiss = { showEditDialog = false }
        )
    }


    if (showSubscriptionDialog) {
        SubscriptionDialog(onDismiss = { showSubscriptionDialog = false })
    }


    if (showDeleteConfirmation) {
        DeleteConfirmationDialog(
            onDismiss = { showDeleteConfirmation = false },
            onConfirm = { }
        )
    }
}

@Composable
fun EditProfileDialog(
    name: String,
    onNameChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    birthDate: String,
    onBirthDateChange: (String) -> Unit,
    weight: String,
    onWeightChange: (String) -> Unit,
    height: String,
    onHeightChange: (String) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Editar Perfil") },
        text = {
            Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = onNameChange,
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = onEmailChange,
                    label = { Text("Correo Electrónico") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = birthDate,
                    onValueChange = onBirthDateChange,
                    label = { Text("Fecha de Nacimiento") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = weight,
                    onValueChange = onWeightChange,
                    label = { Text("Peso") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = height,
                    onValueChange = onHeightChange,
                    label = { Text("Altura") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Guardar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}

@Composable
fun SubscriptionDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Estado de Suscripción") },
        text = { Text("Actualmente estás suscrito al Plan Premium.") },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text("Cerrar")
            }
        }
    )
}

@Composable
fun DeleteConfirmationDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Eliminar Perfil") },
        text = { Text("¿Estás seguro de que deseas eliminar tu perfil? Esta acción no se puede deshacer.") },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text("Eliminar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}