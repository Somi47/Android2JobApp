package com.example.android2jobapp.test

import android.os.Looper.getMainLooper
import com.example.android2jobapp.model.Job
import com.example.android2jobapp.testInjector
import com.example.android2jobapp.ui.main.MainPresenter
import com.example.android2jobapp.ui.main.MainScreen
import com.example.android2jobapp.utils.argumentCaptor
import com.example.android2jobapp.utils.capture
import com.example.android2jobapp.utils.mock
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.any
import org.mockito.Captor
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class MainTest {
    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var mainScreen: MainScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun testShowJobs() {
        mainPresenter.refreshJobs()
        shadowOf(getMainLooper()).idle();

        var job1 = Job()
        job1.id = "jobid1"
        job1.title = "Best android job"
        job1.company = "Google"
        job1.description = "Best android job for you bla bla"

        var job2 = Job()
        job2.id = "jobid2"
        job2.title = "Second best android job"
        job2.company = "Oracle"
        job2.description = "Second best android job for you bla bla"

        var list = listOf(job1, job2)
        Mockito.verify(mainScreen).showJobs(list)
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}