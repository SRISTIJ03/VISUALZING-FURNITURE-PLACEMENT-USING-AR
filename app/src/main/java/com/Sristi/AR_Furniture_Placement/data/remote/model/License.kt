package com.Sristi.AR_Furniture_Placement.data.remote.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class License(
    @SerializedName("label")
    val label: String?,
    @SerializedName("uid")
    val uid: String
)
