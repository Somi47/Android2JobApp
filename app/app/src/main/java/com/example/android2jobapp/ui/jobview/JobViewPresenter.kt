package com.example.android2jobapp.ui.jobview

import com.example.android2jobapp.interactor.job.GetJobEvent
import com.example.android2jobapp.interactor.job.JobInteractor
import com.example.android2jobapp.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class JobViewPresenter @Inject constructor(private val executor: Executor, private val jobInteractor : JobInteractor) : Presenter<JobViewScreen>() {
    override fun attachScreen(screen: JobViewScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }
    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshJob(id: String) {
        executor.execute {
            jobInteractor.getJob(id)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetJobEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
        } else {
            if (screen != null) {
                if (event.job != null) {
                    screen?.showJob(event.job!!)
                }

            }
        }
    }
}