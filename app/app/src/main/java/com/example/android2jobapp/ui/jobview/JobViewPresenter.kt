package com.example.android2jobapp.ui.jobview

import com.example.android2jobapp.interactor.JobInteractor
import com.example.android2jobapp.model.Job
import com.example.android2jobapp.ui.Presenter
import java.util.concurrent.Executor
import javax.inject.Inject

class JobViewPresenter @Inject constructor(private val executor: Executor, private val jobInteractor : JobInteractor) : Presenter<JobViewScreen>() {
    override fun attachScreen(screen: JobViewScreen) {
        super.attachScreen(screen)
    }
    override fun detachScreen() {
        super.detachScreen()
    }
    fun refreshJob() {
        var job: Job = Job()
        screen?.showJob(job);
    }
}