package com.Sristi.AR_Furniture_Placement.data.remote

import com.Sristi.AR_Furniture_Placement.data.remote.api.ApiService
import com.Sristi.AR_Furniture_Placement.data.remote.api.DownloadService
import com.Sristi.AR_Furniture_Placement.data.remote.apiresult.ApiResult
import com.Sristi.AR_Furniture_Placement.data.remote.model.DownloadStatus
import com.Sristi.AR_Furniture_Placement.data.remote.model.NetworkDownload
import com.Sristi.AR_Furniture_Placement.data.remote.model.NetworkModel
import com.Sristi.AR_Furniture_Placement.data.remote.model.NetworkModels
import kotlinx.coroutines.flow.Flow
import java.nio.file.Path
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val apiService: ApiService,
    private val downloadService: DownloadService,
) {

    suspend fun getModels(tag: String, cursor: String): ApiResult<NetworkModels> =
        apiService.getModels(tag, cursor)

    suspend fun getModelInfo(modelId: String): ApiResult<NetworkModel> =
        apiService.getModelInfo(modelId)

    suspend fun getDownloadInfo(modelId: String): ApiResult<NetworkDownload> =
        apiService.getDownloadInfo(modelId)

    suspend fun downloadModel(path: Path, url: String): Flow<DownloadStatus> =
        downloadService.download(path, url)
}
