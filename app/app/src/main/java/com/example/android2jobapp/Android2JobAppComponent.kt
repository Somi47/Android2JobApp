package com.example.android2jobapp

import com.example.android2jobapp.client.api.NetworkModule
import com.example.android2jobapp.interactor.InteractorModule
import com.example.android2jobapp.ui.UIModule
import com.example.android2jobapp.ui.jobview.JobViewActivity
import com.example.android2jobapp.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface Android2JobAppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(jobViewActivity: JobViewActivity)
}