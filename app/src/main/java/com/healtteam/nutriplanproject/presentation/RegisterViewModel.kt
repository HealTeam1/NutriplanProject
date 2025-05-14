package com.healtteam.nutriplanproject.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.healtteam.nutriplanproject.domain.usecase.RegisterUserUseCase
import com.healtteam.nutriplanproject.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(private val registerUseCase: RegisterUserUseCase) : ViewModel() {
    private val _registerState = MutableStateFlow(false)
    val registerState: StateFlow<Boolean> get() = _registerState

    fun register(
        firstName: String,
        lastName: String,
        birthDate: String,
        weight: String,
        height: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        viewModelScope.launch {
            if (password == confirmPassword) {
                val user = User(firstName, lastName, birthDate, weight, height, email, password)
                _registerState.value = registerUseCase.execute(user)
            } else {
                _registerState.value = false
            }
        }
    }
}