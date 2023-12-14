package com.D121211094.Bobburgers.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Parcelize
@Serializable
data class Relative(
    @SerialName(value = "_id")
    val _id: String? = null,
    @SerialName(value ="name")
    val name: String? = null,
    @SerialName(value = "relationship")
    val relationship: String? = null,
    @SerialName(value ="url")
    val url: String? = null,
    @SerialName(value ="wikiUrl")
    val wikiUrl: String? = null,
): Parcelable