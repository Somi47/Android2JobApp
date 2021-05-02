package com.example.android2jobapp.mock

import com.example.android2jobapp.client.api.ApplicationApi
import com.example.android2jobapp.client.api.JobApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class MockNetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideJobApi(client: OkHttpClient): JobApi {
        return MockJobApi()
    }

    @Provides
    @Singleton
    fun provideApplicationApi(client: OkHttpClient): ApplicationApi {
        return MockApplicationApi()
    }
}