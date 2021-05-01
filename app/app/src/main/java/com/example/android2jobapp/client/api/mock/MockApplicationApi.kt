package com.example.android2jobapp.client.api.mock

import com.example.android2jobapp.client.api.ApplicationApi
import com.example.android2jobapp.model.Application
import retrofit2.Call

class MockApplicationApi : ApplicationApi {
    override fun getApplications(): Call<Array<Application>> {
        TODO("Not yet implemented")
    }

    override fun getApplicationId(id: String): Call<Application> {
        TODO("Not yet implemented")
    }

    override fun postApplication(body: Application): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun putApplicationId(id: String, body: Application): Call<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteApplicationId(id: String): Call<Void> {
        TODO("Not yet implemented")
    }
}