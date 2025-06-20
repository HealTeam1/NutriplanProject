package com.healtteam.nutriplanproject

import android.app.Application

class NutriPlanApplication  : Application() {

    companion object {
        lateinit var instance: NutriPlanApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}