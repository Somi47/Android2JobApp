package com.example.android2jobapp

import android.content.Context
import com.example.android2jobapp.client.api.ApplicationApi
import com.example.android2jobapp.client.api.JobApi
import com.example.android2jobapp.interactor.application.ApplicationInteractor
import com.example.android2jobapp.interactor.job.JobInteractor
import com.example.android2jobapp.mock.MockApplicationApi
import com.example.android2jobapp.mock.MockJobApi
import com.example.android2jobapp.ui.jobview.JobViewPresenter
import com.example.android2jobapp.ui.main.MainPresenter
import com.example.android2jobapp.utils.UiExecutor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.GsonConverterFactory
import retrofit2.Retrofit
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {
    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, jobInteractor: JobInteractor) = MainPresenter(executor, jobInteractor)

    @Provides
    @Singleton
    fun jobViewPresenter(executor: Executor, jobInteractor: JobInteractor, applicationInteractor: ApplicationInteractor) = JobViewPresenter(executor, jobInteractor, applicationInteractor)

    @Provides
    @Singleton
    fun networkExecutor(): Executor = UiExecutor()
}