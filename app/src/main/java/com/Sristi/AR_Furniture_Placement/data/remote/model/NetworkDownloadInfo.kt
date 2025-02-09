package com.Sristi.AR_Furniture_Placement.data.remote.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class NetworkDownloadInfo(
    @SerializedName("url")
    val url: String,
    @SerializedName("size")
    val size: Long,
    @SerializedName("expires")
    val expires: Long
)
