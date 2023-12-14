package com.D121211094.Bobburgers.data.repository

import com.D121211094.Bobburgers.data.response.GetCharResponse
import com.D121211094.Bobburgers.data.source.remote.ApiService
import com.D121211094.Bobburgers.data.models.Character

class CharRepository (private val apiService: ApiService){

    suspend fun getChar(): List<Character>{
        return apiService.getChar()
    }
}