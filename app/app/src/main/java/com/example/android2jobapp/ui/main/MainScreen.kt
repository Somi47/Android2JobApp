package com.example.android2jobapp.ui.main

import com.example.android2jobapp.model.Job

interface MainScreen {
    fun showJobs(result: List<Job>)
}