package com.example.android2jobapp.test

import android.os.Looper
import com.example.android2jobapp.model.Job
import com.example.android2jobapp.testInjector
import com.example.android2jobapp.ui.jobview.JobViewPresenter
import com.example.android2jobapp.ui.jobview.JobViewScreen
import com.example.android2jobapp.ui.main.MainPresenter
import com.example.android2jobapp.ui.main.MainScreen
import com.example.android2jobapp.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class JobViewTest {
    @Inject
    lateinit var jobViewPresenter: JobViewPresenter
    private lateinit var jobViewScreen: JobViewScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        jobViewScreen = mock()
        jobViewPresenter.attachScreen(jobViewScreen)
    }

    @Test
    fun testShowJob() {
        jobViewPresenter.refreshJob("jobid1")
        Shadows.shadowOf(Looper.getMainLooper()).idle();

        var job1 = Job()
        job1.id = "jobid1"
        job1.title = "Best android job"
        job1.company = "Google"
        job1.description = "Best android job for you bla bla"

        Mockito.verify(jobViewScreen).showJob(job1)
    }

    @Test
    fun testShowInitialApplicationStatus() {
        jobViewPresenter.refreshApplicationStatus("jobid1")
        Shadows.shadowOf(Looper.getMainLooper()).idle();

        Mockito.verify(jobViewScreen).showApplicationStatus(false)
    }

    @Test
    fun testSetApplicationStatusApplied() {
        jobViewPresenter.setApplicationStatus("jobid1", true)
        Shadows.shadowOf(Looper.getMainLooper()).idle();

        Mockito.verify(jobViewScreen).showApplicationStatus(true)
    }

    @Test
    fun testSetApplicationStatusBackAndForth() {
        jobViewPresenter.refreshApplicationStatus("jobid1")
        Shadows.shadowOf(Looper.getMainLooper()).idle();

        Mockito.verify(jobViewScreen).showApplicationStatus(false)
        Mockito.reset(jobViewScreen)

        jobViewPresenter.setApplicationStatus("jobid1", true)
        Shadows.shadowOf(Looper.getMainLooper()).idle();

        Mockito.verify(jobViewScreen).showApplicationStatus(true)
        Mockito.reset(jobViewScreen)

        jobViewPresenter.refreshApplicationStatus("jobid1")
        Shadows.shadowOf(Looper.getMainLooper()).idle();

        Mockito.verify(jobViewScreen).showApplicationStatus(true)
        Mockito.reset(jobViewScreen)

        jobViewPresenter.setApplicationStatus("jobid1", false)
        Shadows.shadowOf(Looper.getMainLooper()).idle();

        Mockito.verify(jobViewScreen).showApplicationStatus(false)
    }

    @After
    fun tearDown() {
        jobViewPresenter.detachScreen()
    }
}