package com.example.android2jobapp.interactor

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideJobInteractor() = JobInteractor()
}