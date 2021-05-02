package com.example.android2jobapp.mock

import com.example.android2jobapp.client.api.JobApi
import com.example.android2jobapp.model.Application
import com.example.android2jobapp.model.Job
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MockJobApi : JobApi {
    override fun getJobs(search: String): Call<Array<Job>> {
        return object: Call<Array<Job>> {
            override fun enqueue(callback: Callback<Array<Job>>?) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun clone(): Call<Array<Job>> {
                return this
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun cancel() {
            }

            override fun execute(): Response<Array<Job>> {
                // Create your mock data in here

                var job1 = Job()
                job1.id = "jobid1"
                job1.title = "Best android job"
                job1.company = "Google"
                job1.description = "Best android job for you bla bla"

                var job2 = Job()
                job2.id = "jobid2"
                job2.title = "Second best android job"
                job2.company = "Oracle"
                job2.description = "Second best android job for you bla bla"

                return Response.success(arrayOf(job1, job2))
            }
        }
    }

    override fun getJobId(id: String): Call<Job> {
        return object: Call<Job> {
            override fun enqueue(callback: Callback<Job>?) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun clone(): Call<Job> {
                return this
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun cancel() {
            }

            override fun execute(): Response<Job> {
                // Create your mock data in here

                var job1 = Job()
                job1.id = "jobid1"
                job1.title = "Best android job"
                job1.company = "Google"
                job1.description = "Best android job for you bla bla"
                return Response.success(job1)
            }
        }
    }
}