package com.D121211094.Bobburgers.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.D121211094.Bobburgers.data.repository.CharRepository
import com.D121211094.Bobburgers.data.source.remote.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val charRepository: CharRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://bobsburgers-api.herokuapp.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val charRepository: CharRepository
        get() = CharRepository(retrofitService)

}