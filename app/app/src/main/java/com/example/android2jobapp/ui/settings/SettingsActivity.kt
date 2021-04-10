package com.example.android2jobapp.ui.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android2jobapp.R
import com.example.android2jobapp.model.Job
import com.example.android2jobapp.model.Settings

class SettingsActivity : AppCompatActivity(), SettingsScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }

    override fun onStart() {
        super.onStart()
        SettingsPresenter.attachScreen(this)
    }
    override fun onStop() {
        super.onStop()
        SettingsPresenter.detachScreen()
    }

    override fun showSettings(result: Settings) {
        Toast.makeText(
            this,
            "Result: $result",
            Toast.LENGTH_LONG
        )
    }
}