package com.example.android2jobapp.interactor

import com.example.android2jobapp.model.Job

data class GetJobsEvent(
    var code: Int = 0,
    var jobs: List<Job>? = null,
    var throwable: Throwable? = null
)