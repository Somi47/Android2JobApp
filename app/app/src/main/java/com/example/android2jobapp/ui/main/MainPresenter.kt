package com.example.android2jobapp.ui.main

import com.example.android2jobapp.interactor.job.GetJobsEvent
import com.example.android2jobapp.model.Job
import com.example.android2jobapp.ui.Presenter
import com.example.android2jobapp.interactor.job.JobInteractor
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val executor: Executor, private val jobInteractor : JobInteractor) : Presenter<MainScreen>() {
    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }
    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }
    fun refreshJobs() {
        executor.execute {
            jobInteractor.getJobs()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetJobsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
        } else {
            if (screen != null) {
                if (event.jobs != null) {
                    screen?.showJobs(event.jobs as MutableList<Job>)
                }

            }
        }
    }
}