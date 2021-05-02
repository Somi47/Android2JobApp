package com.example.android2jobapp

import org.robolectric.RuntimeEnvironment
import org.robolectric.shadows.ShadowLog

val testInjector: TestComponent
    get() {
        ShadowLog.stream = System.out
        val application = RuntimeEnvironment.application // as Android2JobApp
        val component = DaggerTestComponent.builder().testModule(TestModule(application.applicationContext)).build()
        //application.injector = component
        return component
    }