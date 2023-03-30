package com.setjy.automationbusinesstask

import android.app.Application
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        MapKitFactory.setApiKey("0452e5ac-cc94-4468-88bf-0968e0604c08")
    }
}