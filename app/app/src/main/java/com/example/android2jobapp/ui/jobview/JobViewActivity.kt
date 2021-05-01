package com.example.android2jobapp.ui.jobview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android2jobapp.R
import com.example.android2jobapp.injector
import com.example.android2jobapp.model.Job
import com.example.android2jobapp.orm.AppDatabase
import com.example.android2jobapp.orm.entity.ApplicationEntity
import com.example.android2jobapp.ui.settings.PreferenceActivity
import javax.inject.Inject

class JobViewActivity : AppCompatActivity(), JobViewScreen {
    @Inject
    lateinit var jobViewPresenter: JobViewPresenter

    var id = ""
    var tvJobTitle : TextView? = null
    var tvJobCompany : TextView? = null
    var tvJobDesc : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_view)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setHomeButtonEnabled(true);
        injector.inject(this)
        id = intent.getStringExtra("id")!!

        tvJobTitle = findViewById(R.id.tvJobTitle)
        tvJobCompany = findViewById(R.id.tvJobCompany)
        tvJobDesc = findViewById(R.id.tvJobDesc)

        val buttonApply: Button = findViewById<View>(R.id.btApply) as Button

        val dbThread = Thread {
            val application = AppDatabase.getInstance(this@JobViewActivity).applicationDao().getApplicationForJobId(id)
            runOnUiThread {
                if(application!=null)
                    buttonApply.text = "Undo"
            }
        }
        dbThread.start()

        buttonApply.setOnClickListener {
            val application = ApplicationEntity(0, "", id)
            val dbThread = Thread {
                AppDatabase.getInstance(this@JobViewActivity).applicationDao().insertApplication(application)
            }
            dbThread.start()
        }
    }

    override fun onStart() {
        super.onStart()
        jobViewPresenter.attachScreen(this)
        jobViewPresenter.refreshJob(id)
    }
    override fun onStop() {
        super.onStop()
        jobViewPresenter.detachScreen()
    }

    override fun showJob(result: Job) {
        tvJobTitle?.text = result.title
        tvJobCompany?.text = result.company
        tvJobDesc?.text = result.description
    }
}