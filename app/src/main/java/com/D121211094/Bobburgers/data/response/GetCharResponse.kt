package com.D121211094.Bobburgers.data.response

import com.D121211094.Bobburgers.data.models.Character
import com.D121211094.Bobburgers.data.models.Relative
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetCharResponse (
    @SerialName("data")
    val data: List<Character>
)
