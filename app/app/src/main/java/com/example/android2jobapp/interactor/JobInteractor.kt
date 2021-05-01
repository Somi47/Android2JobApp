package com.example.android2jobapp.interactor

import com.example.android2jobapp.model.Job
import javax.inject.Inject

class JobInteractor @Inject constructor() {
    fun getJobs(): List<Job>
    {
        val jobs: MutableList<Job> = mutableListOf<Job>()
        val job1 = Job()
        job1.title = "HelloWorld"
        jobs.add(job1)
        return jobs
    }
}