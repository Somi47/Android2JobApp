package com.example.android2jobapp.mock

import com.example.android2jobapp.client.api.ApplicationApi
import com.example.android2jobapp.model.Application
import com.example.android2jobapp.orm.AppDatabase
import com.example.android2jobapp.orm.entity.ApplicationEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MockApplicationApi : ApplicationApi {
    var applied = false

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
                if(applied) {
                    var application = Application()
                    application.id = 123
                    application.email = "test@test.com"
                    application.jobid = "321"
                    return Response.success(application)
                }
                else
                {
                    return Response.success(null)
                }
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
                applied = true
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
                applied = false
                return Response.success(null)
            }
        }
    }
}