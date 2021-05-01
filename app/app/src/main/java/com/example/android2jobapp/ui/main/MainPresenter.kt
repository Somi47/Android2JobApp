package com.example.android2jobapp.ui.main

import com.example.android2jobapp.model.Job
import com.example.android2jobapp.ui.Presenter
import com.example.android2jobapp.interactor.JobInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val jobInteractor : JobInteractor) : Presenter<MainScreen>() {
    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
    }
    override fun detachScreen() {
        super.detachScreen()
    }
    fun refreshJobs() {
        var jobs: List<Job> = jobInteractor.getJobs()
        screen?.showJobs(jobs);
    }
}