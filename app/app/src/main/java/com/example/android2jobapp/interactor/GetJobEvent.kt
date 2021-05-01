package com.example.android2jobapp.interactor

import com.example.android2jobapp.model.Job

data class GetJobEvent(
    var code: Int = 0,
    var job: Job? = null,
    var throwable: Throwable? = null
)