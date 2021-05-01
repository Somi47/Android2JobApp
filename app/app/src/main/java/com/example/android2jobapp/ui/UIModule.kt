package com.example.android2jobapp.ui

import android.content.Context
import com.example.android2jobapp.interactor.JobInteractor
import com.example.android2jobapp.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {
    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, jobInteractor: JobInteractor) = MainPresenter(executor, jobInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}