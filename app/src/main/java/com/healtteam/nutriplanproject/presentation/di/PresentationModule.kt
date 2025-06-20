package com.healtteam.nutriplanproject.presentation.di

import com.healtteam.nutriplanproject.data.di.DataModule
import com.healtteam.nutriplanproject.presentation.viewmodel.PacientesViewModel
import com.healtteam.nutriplanproject.presentation.viewmodel.PlanesViewModel
import com.healtteam.nutriplanproject.presentation.viewmodel.PerfilViewModel

object PresentationModule {

    fun getPacientesViewModel(): PacientesViewModel {
        return PacientesViewModel(DataModule.getPacienteRepository())
    }

    fun getPlanesViewModel(): PlanesViewModel {
        return PlanesViewModel(DataModule.getNutricionistaRepository())
    }

    fun getPerfilViewModel(): PerfilViewModel {
        return PerfilViewModel(DataModule.getNutricionistaRepository())
    }
}