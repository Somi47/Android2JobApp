package com.example.android2jobapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android2jobapp.R
import com.example.android2jobapp.injector
import com.example.android2jobapp.model.Job
import com.example.android2jobapp.ui.jobview.JobViewActivity
import com.example.android2jobapp.ui.settings.PreferenceActivity
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainScreen, MyRecyclerViewAdapter.ItemClickListener {
    @Inject
    lateinit var mainPresenter: MainPresenter
    var adapter: MyRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        val buttonSettings: ImageButton = findViewById<View>(R.id.ib_settings) as ImageButton
        buttonSettings.setOnClickListener {
            val intent = Intent(this@MainActivity, PreferenceActivity::class.java)
            startActivity(intent)
        }

        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
        mainPresenter.refreshJobs()
    }
    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    override fun showJobs(result: List<Job>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewJobs)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter(this, result)
        adapter!!.setClickListener(this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(view: View?, position: Int) {
        /*Toast.makeText(
            this,
            "You clicked " + adapter?.getItem(position).toString() + " on row number " + position,
            Toast.LENGTH_SHORT
        ).show()*/

        val intent = Intent(this, JobViewActivity::class.java).apply {
            putExtra("id", adapter?.getItem(position)?.id)
        }
        startActivity(intent)
    }
}