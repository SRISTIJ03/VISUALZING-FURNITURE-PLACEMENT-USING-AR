package com.Sristi.AR_Furniture_Placement.data.repository

import androidx.paging.PagingData
import com.Sristi.AR_Furniture_Placement.data.model.Category
import com.Sristi.AR_Furniture_Placement.data.model.CategoryInfo
import com.Sristi.AR_Furniture_Placement.data.model.DownloadInfo
import com.Sristi.AR_Furniture_Placement.data.model.Product
import com.Sristi.AR_Furniture_Placement.data.remote.model.DownloadStatus
import com.Sristi.AR_Furniture_Placement.utils.result.Result
import kotlinx.coroutines.flow.Flow
import java.nio.file.Path

interface ModelRepository {

    suspend fun getModels(category: Category): Flow<PagingData<Product>>

    fun getCategories(): List<Category>

    suspend fun getProductCategory(productId: String): CategoryInfo

    suspend fun getDownloadInfo(modelId: String): Flow<Result<DownloadInfo>>

    suspend fun download(path: Path, url: String): Flow<DownloadStatus>
}
