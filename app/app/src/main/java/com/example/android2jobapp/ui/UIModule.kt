package com.example.android2jobapp.ui

import android.content.Context
import com.example.android2jobapp.interactor.JobInteractor
import com.example.android2jobapp.ui.jobview.JobViewPresenter
import com.example.android2jobapp.ui.main.MainPresenter
import com.example.android2jobapp.ui.settings.SettingsPresenter
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
    fun jobViewPresenter(executor: Executor, jobInteractor: JobInteractor) = JobViewPresenter(executor, jobInteractor)

    @Provides
    @Singleton
    fun settingsPresenter() = SettingsPresenter()

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}