package com.example.android2jobapp.client.api.mock

import com.example.android2jobapp.client.api.JobApi
import com.example.android2jobapp.model.Job
import retrofit2.Call

class MockJobApi : JobApi {
    override fun getJobs(): Call<Array<Job>> {
        TODO("Not yet implemented")
    }

    override fun getJobId(id: String): Call<Job> {
        TODO("Not yet implemented")
    }
}