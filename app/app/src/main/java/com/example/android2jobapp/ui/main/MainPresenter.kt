package com.example.android2jobapp.ui.main

import com.example.android2jobapp.model.Job
import com.example.android2jobapp.ui.Presenter

object MainPresenter : Presenter<MainScreen>() {
    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
    }
    override fun detachScreen() {
        super.detachScreen()
    }
    fun refreshJobs() {
        var jobs: List<Job> = listOf<Job>()
        screen?.showJobs(jobs);
    }
}