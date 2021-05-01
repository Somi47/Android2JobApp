package com.example.android2jobapp

import android.app.Application
import com.example.android2jobapp.ui.UIModule

class Android2JobApp: Application() {
    lateinit var injector: Android2JobAppComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerAndroid2JobAppComponent.builder().uIModule(UIModule(this)).build()
    }
}