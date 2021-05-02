package com.example.android2jobapp.interactor.job

import com.example.android2jobapp.client.api.JobApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class JobInteractor @Inject constructor(private var jobApi: JobApi) {
    fun getJobs()
    {
        val event = GetJobsEvent()

        try {
            val jobsCall = jobApi.getJobs("android")
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

    fun getJob(id: String)
    {
        val event = GetJobEvent()

        try {
            val jobsCall = jobApi.getJobId(id)
            val response = jobsCall.execute()
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.job = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}