package com.example.android2jobapp.interactor.application

import com.example.android2jobapp.client.api.ApplicationApi
import com.example.android2jobapp.client.api.JobApi
import com.example.android2jobapp.interactor.job.GetJobsEvent
import com.example.android2jobapp.orm.AppDatabase
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class ApplicationInteractor @Inject constructor(private var applicationApi: ApplicationApi) {
    fun getApplicationStatus(jobId: String){
        val event = GetApplicationStatusEvent()

        val dbThread = Thread {
            val application = AppDatabase.getInstance().applicationDao().getApplicationForJobId(jobId)
            event.applied = application!=null
            EventBus.getDefault().post(event)
        }
        dbThread.start()
    }
}