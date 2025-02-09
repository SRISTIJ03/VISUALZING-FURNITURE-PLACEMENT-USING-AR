package com.Sristi.AR_Furniture_Placement.data.model

import com.Sristi.AR_Furniture_Placement.data.remote.model.NetworkDownloadInfo

data class DownloadInfo(
    val url: String,
    val totalSize: Long
)

fun NetworkDownloadInfo.asExternalModel() = DownloadInfo(
    url = url,
    totalSize = size
)
