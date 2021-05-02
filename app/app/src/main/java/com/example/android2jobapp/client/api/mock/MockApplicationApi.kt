package com.example.android2jobapp.client.api.mock

import com.example.android2jobapp.client.api.ApplicationApi
import com.example.android2jobapp.model.Application
import com.example.android2jobapp.orm.AppDatabase
import com.example.android2jobapp.orm.entity.ApplicationEntity
import com.google.gson.Gson
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MockApplicationApi : ApplicationApi {
    override fun getApplications(): Call<Array<Application>> {
        TODO("Not yet implemented, not needed to mock")
    }

    override fun getApplicationId(id: String): Call<Application?> {
        return object: Call<Application?> {
            override fun enqueue(callback: Callback<Application?>?) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun clone(): Call<Application?> {
                return this
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun cancel() {
            }

            override fun execute(): Response<Application?> {
                // Create your mock data in here
                val applicationEntity = AppDatabase.getInstance().applicationDao().getApplicationForJobId(id) //TODO rename
                if(applicationEntity==null)
                    return Response.success(null)

                var application = Application()
                application.id = applicationEntity?.id
                application.email = applicationEntity?.email
                application.jobid = applicationEntity?.jobid
                return Response.success(application)
            }

        }
    }

    override fun postApplication(body: Application): Call<Void?> {
        return object: Call<Void?> {
            override fun enqueue(callback: Callback<Void?>?) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun clone(): Call<Void?> {
                return this
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun cancel() {
            }

            override fun execute(): Response<Void?> {
                val application = ApplicationEntity(0, body.email!!, body.jobid!!)
                AppDatabase.getInstance().applicationDao().insertApplication(application)
                return Response.success(null)
            }
        }
    }

    override fun putApplicationId(id: String, body: Application): Call<Void?> {
        TODO("Not yet implemented, not needed to mock")
    }

    override fun deleteApplicationId(id: String): Call<Void?> {
        return object: Call<Void?> {
            override fun enqueue(callback: Callback<Void?>?) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun clone(): Call<Void?> {
                return this
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun cancel() {
            }

            override fun execute(): Response<Void?> {
                val application = AppDatabase.getInstance().applicationDao().getApplicationForJobId(id)!!
                AppDatabase.getInstance().applicationDao().deleteApplication(application)
                return Response.success(null)
            }
        }
    }
}