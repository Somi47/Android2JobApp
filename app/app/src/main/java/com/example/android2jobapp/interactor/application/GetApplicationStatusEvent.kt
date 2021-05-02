package com.example.android2jobapp.interactor.application

import com.example.android2jobapp.model.Job

data class GetApplicationStatusEvent(
    var applied: Boolean? = null
)