package com.example.android2jobapp.interactor

import com.example.android2jobapp.client.api.JobApi
import com.example.android2jobapp.model.Job
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class JobInteractor @Inject constructor(private var jobApi: JobApi) {
    fun getJobs()
    {
        val event = GetJobsEvent()

        try {
            val jobsCall = jobApi.getJobs()
            val response = jobsCall.execute()
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.jobs = response.body().toList()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}