package com.D121211094.Bobburgers.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Character(
    @SerialName(value = "age")
    val age: String? = "Unknown",
    @SerialName(value = "allOccupations")
    val allOccupations: List<String>,
    @SerialName(value = "firstEpisode")
    val firstEpisode: String? =null,
    @SerialName(value = "gender")
    val gender: String? = null,
    @SerialName(value = "hair")
    val hair: String? = null,
    @SerialName(value = "id")
    val id: Int? = null,
    @SerialName(value = "image")
    val image: String? = null,
    @SerialName(value = "name")
    val name: String? = null,
    @SerialName(value = "occupation")
    val occupation: String? = null,
    @SerialName(value = "relatives")
    val relatives: List<Relative>,
    @SerialName(value = "url")
    val url: String? = null,
    @SerialName(value = "voicedBy")
    val voicedBy: String? = null,
    @SerialName(value = "wikiUrl")
    val wikiUrl: String? = null
): Parcelable