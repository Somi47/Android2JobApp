package com.example.android2jobapp.client.api

import com.example.android2jobapp.model.Job
import retrofit2.Call
import retrofit2.http.*

interface JobApi {

    @GET("positions.json")
    fun getJobs(): Call<Array<Job>?>?

    @GET("positions/{id}.json")
    fun getJobId(
            @Path("id") id: String?
    ): Call<Job?>?


}