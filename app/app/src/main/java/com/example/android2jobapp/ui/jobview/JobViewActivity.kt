package com.example.android2jobapp.ui.jobview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android2jobapp.R
import com.example.android2jobapp.model.Job
import javax.inject.Inject

class JobViewActivity : AppCompatActivity(), JobViewScreen {
    @Inject
    lateinit var jobViewPresenter: JobViewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_view)
    }

    override fun onStart() {
        super.onStart()
        jobViewPresenter.attachScreen(this)
    }
    override fun onStop() {
        super.onStop()
        jobViewPresenter.detachScreen()
    }

    override fun showJob(result: Job) {
        Toast.makeText(
                this,
                "Result: $result",
                Toast.LENGTH_LONG
        )
    }
}