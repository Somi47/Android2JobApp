package com.example.android2jobapp.interactor

import com.example.android2jobapp.client.api.JobApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideJobInteractor(jobApi: JobApi) = JobInteractor(jobApi)
}