package com.example.android2jobapp

import com.example.android2jobapp.interactor.InteractorModule
import com.example.android2jobapp.mock.MockNetworkModule
import com.example.android2jobapp.test.JobViewTest
import com.example.android2jobapp.test.MainTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestModule::class, MockNetworkModule::class, InteractorModule::class])
interface TestComponent : Android2JobAppComponent {
    fun inject(mainTest: MainTest)
    fun inject(jobViewTest: JobViewTest)
}