package com.example.android2jobapp.ui.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android2jobapp.R
import com.example.android2jobapp.injector
import com.example.android2jobapp.model.Settings
import javax.inject.Inject

class SettingsActivity : AppCompatActivity(), SettingsScreen {
    @Inject
    lateinit var settingsPresenter: SettingsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        settingsPresenter.attachScreen(this)
    }
    override fun onStop() {
        super.onStop()
        settingsPresenter.detachScreen()
    }

    override fun showSettings(result: Settings) {
        Toast.makeText(
            this,
            "Result: $result",
            Toast.LENGTH_LONG
        )
    }
}