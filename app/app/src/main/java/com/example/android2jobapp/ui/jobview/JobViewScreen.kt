package com.example.android2jobapp.ui.jobview

import com.example.android2jobapp.model.Job

interface JobViewScreen {
    fun showJob(result: Job)
    fun showApplicationStatus(applied: Boolean)
}