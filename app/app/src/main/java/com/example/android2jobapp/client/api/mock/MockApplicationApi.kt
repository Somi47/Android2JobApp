package com.example.android2jobapp.client.api.mock

import com.example.android2jobapp.client.api.ApplicationApi
import com.example.android2jobapp.model.Application
import com.google.gson.Gson
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MockApplicationApi : ApplicationApi {
    override fun getApplications(): Call<Array<Application>> {
        TODO("Not yet implemented")
    }

    override fun getApplicationId(id: String): Call<Application> {
        return object: Call<Application> {
            override fun enqueue(callback: Callback<Application>?) {
            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun clone(): Call<Application> {
                return this
            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun cancel() {
            }

            override fun execute(): Response<Application> {
                // Create your mock data in here
                var application = Application()
                application.email = "asd"
                application.jobid = id
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
                // Create your mock data in here
                var application = Application()
                application.email = "asd"
                return Response.success(null)
            }

        }
    }

    override fun putApplicationId(id: String, body: Application): Call<Void?> {
        TODO("Not yet implemented")
    }

    override fun deleteApplicationId(id: String): Call<Void?> {
        TODO("Not yet implemented")
    }
}