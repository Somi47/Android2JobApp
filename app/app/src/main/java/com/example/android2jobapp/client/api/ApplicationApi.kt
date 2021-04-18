package com.example.android2jobapp.client.api

import com.example.android2jobapp.model.Application
import retrofit2.Call
import retrofit2.http.*

interface ApplicationApi {
    @GET("application")
    fun getApplications(): Call<Array<Application>?>?

    @GET("application/{id}")
    fun getApplicationId(
            @Path("id") id: String?
    ): Call<Application?>?

    @POST("application")
    fun postApplication(
            @Body body: Application?
    ): Call<Void?>?

    @PUT("application/{id}")
    fun putApplicationId(
            @Path("id") id: String?, @Body body: Application?
    ): Call<Void?>?

    @DELETE("application/{id}")
    fun deleteApplicationId(
            @Path("id") id: String?
    ): Call<Void?>?
}