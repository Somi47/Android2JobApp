package com.example.android2jobapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android2jobapp.R
import com.example.android2jobapp.model.Job
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen {
    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }
    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    override fun showJobs(result: List<Job>) {
        Toast.makeText(
                this,
                "Result: $result",
                Toast.LENGTH_LONG
        )
    }

}