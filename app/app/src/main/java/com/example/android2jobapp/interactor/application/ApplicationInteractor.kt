package com.example.android2jobapp.interactor.application

import com.example.android2jobapp.client.api.ApplicationApi
import com.example.android2jobapp.client.api.JobApi
import com.example.android2jobapp.interactor.job.GetJobsEvent
import com.example.android2jobapp.model.Application
import com.example.android2jobapp.orm.AppDatabase
import com.example.android2jobapp.orm.entity.ApplicationEntity
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class ApplicationInteractor @Inject constructor(private var applicationApi: ApplicationApi) {
    fun getApplicationStatus(jobId: String){
        val event = GetApplicationStatusEvent()
        val applicationCall = applicationApi.getApplicationId(jobId)
        val response = applicationCall.execute()
        if (response.code() != 200) {
            throw Exception("Result code is not 200")
        }
        event.applied = response.body() != null
        EventBus.getDefault().post(event)
    }

    fun setApplicationStatus(jobId: String, applied: Boolean){
        val event = GetApplicationStatusEvent()

        if(applied)
        {
            var application = Application()
            application.id = 0
            application.email = "foo@bar.com"
            application.jobid = jobId
            val applicationCall = applicationApi.postApplication(application)
            val response = applicationCall.execute()
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
        }
        else
        {
            val applicationCall = applicationApi.deleteApplicationId(jobId)
            val response = applicationCall.execute()
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
        }
        event.applied = applied
        EventBus.getDefault().post(event)
    }
}