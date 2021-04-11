package com.example.android2jobapp.ui.settings

import com.example.android2jobapp.model.Settings
import com.example.android2jobapp.ui.Presenter
import javax.inject.Inject

class SettingsPresenter @Inject constructor() : Presenter<SettingsScreen>() {
    override fun attachScreen(screen: SettingsScreen) {
        super.attachScreen(screen)
    }
    override fun detachScreen() {
        super.detachScreen()
    }
    fun refreshSettings() {
        var settings: Settings = Settings()
        screen?.showSettings(settings);
    }
}