package com.D121211094.Bobburgers.data.source.remote

import com.D121211094.Bobburgers.data.models.Character
import com.D121211094.Bobburgers.data.response.GetCharResponse
import retrofit2.http.GET


interface ApiService {

    //https://bobsburgers-api.herokuapp.com/characters/
    @GET("characters")
    suspend fun getChar(): List<Character>
}