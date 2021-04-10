package com.example.android2jobapp.ui.jobview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android2jobapp.R
import com.example.android2jobapp.model.Job

class JobViewActivity : AppCompatActivity(), JobViewScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_view)
    }

    override fun onStart() {
        super.onStart()
        JobViewPresenter.attachScreen(this)
    }
    override fun onStop() {
        super.onStop()
        JobViewPresenter.detachScreen()
    }

    override fun showJob(result: Job) {
        Toast.makeText(
                this,
                "Result: $result",
                Toast.LENGTH_LONG
        )
    }
}