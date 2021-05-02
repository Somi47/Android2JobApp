package com.example.android2jobapp.interactor

import com.example.android2jobapp.client.api.ApplicationApi
import com.example.android2jobapp.client.api.JobApi
import com.example.android2jobapp.interactor.application.ApplicationInteractor
import com.example.android2jobapp.interactor.job.JobInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideJobInteractor(jobApi: JobApi) = JobInteractor(jobApi)

    @Provides
    @Singleton
    fun provideApplicationInteractor(applicationApi: ApplicationApi) = ApplicationInteractor(applicationApi)
}