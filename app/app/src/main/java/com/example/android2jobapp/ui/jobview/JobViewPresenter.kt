package com.example.android2jobapp.ui.jobview

import com.example.android2jobapp.model.Job
import com.example.android2jobapp.ui.Presenter
import com.example.android2jobapp.ui.main.MainPresenter
import com.example.android2jobapp.ui.main.MainScreen

object JobViewPresenter : Presenter<JobViewScreen>() {
    override fun attachScreen(screen: JobViewScreen) {
        super.attachScreen(screen)
    }
    override fun detachScreen() {
        super.detachScreen()
    }
    fun refreshJob() {
        var job: Job = Job()
        JobViewPresenter.screen?.showJob(job);
    }
}