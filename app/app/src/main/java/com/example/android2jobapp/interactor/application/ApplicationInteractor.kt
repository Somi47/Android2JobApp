package com.example.android2jobapp.interactor.application

import com.example.android2jobapp.client.api.ApplicationApi
import com.example.android2jobapp.client.api.JobApi
import com.example.android2jobapp.interactor.job.GetJobsEvent
import com.example.android2jobapp.orm.AppDatabase
import com.example.android2jobapp.orm.entity.ApplicationEntity
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class ApplicationInteractor @Inject constructor(private var applicationApi: ApplicationApi) {
    fun getApplicationStatus(jobId: String){
        val event = GetApplicationStatusEvent()

        val application = AppDatabase.getInstance().applicationDao().getApplicationForJobId(jobId)
        event.applied = application!=null
        EventBus.getDefault().post(event)
    }

    fun setApplicationStatus(jobId: String, applied: Boolean){
        val event = GetApplicationStatusEvent()

        if(applied)
        {
            val application = ApplicationEntity(0, "foo@bar.com", jobId)
            AppDatabase.getInstance().applicationDao().insertApplication(application)
        }
        else
        {
            val application = AppDatabase.getInstance().applicationDao().getApplicationForJobId(jobId)!!
            AppDatabase.getInstance().applicationDao().deleteApplication(application)
        }
        event.applied = applied
        EventBus.getDefault().post(event)
    }
}