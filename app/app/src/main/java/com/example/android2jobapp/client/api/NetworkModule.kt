package com.example.android2jobapp.client.api

import com.example.android2jobapp.client.api.mock.MockApplicationApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.GsonConverterFactory
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideJobApi(client: OkHttpClient): JobApi {
        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl("https://jobs.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(JobApi::class.java)
    }

    @Provides
    @Singleton
    fun provideApplicationApi(client: OkHttpClient): ApplicationApi {
        return MockApplicationApi()
    }
}