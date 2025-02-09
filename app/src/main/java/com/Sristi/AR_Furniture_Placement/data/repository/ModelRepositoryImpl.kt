package com.Sristi.AR_Furniture_Placement.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.Sristi.AR_Furniture_Placement.data.local.LocalDataSource
import com.Sristi.AR_Furniture_Placement.data.local.database.SSFurniCraftARDatabase
import com.Sristi.AR_Furniture_Placement.data.local.database.dao.CategoryAndProductDao
import com.Sristi.AR_Furniture_Placement.data.local.database.model.ProductEntity
import com.Sristi.AR_Furniture_Placement.data.model.Category
import com.Sristi.AR_Furniture_Placement.data.model.CategoryInfo
import com.Sristi.AR_Furniture_Placement.data.model.DownloadInfo
import com.Sristi.AR_Furniture_Placement.data.model.Product
import com.Sristi.AR_Furniture_Placement.data.model.asExternalModel
import com.Sristi.AR_Furniture_Placement.data.remote.NetworkDataSource
import com.Sristi.AR_Furniture_Placement.data.remote.apiresult.ApiError
import com.Sristi.AR_Furniture_Placement.data.remote.apiresult.ApiException
import com.Sristi.AR_Furniture_Placement.data.remote.apiresult.ApiSuccess
import com.Sristi.AR_Furniture_Placement.data.remote.mediator.ModelRemoteMediator
import com.Sristi.AR_Furniture_Placement.data.remote.model.DownloadStatus
import com.Sristi.AR_Furniture_Placement.domain.GetPlaneTypeByCategoryUseCase
import com.Sristi.AR_Furniture_Placement.utils.result.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.nio.file.Path
import javax.inject.Inject

class ModelRepositoryImpl @Inject constructor(
    private val categoryAndProductDao: CategoryAndProductDao,
    private val database: SSFurniCraftARDatabase,
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource,
    private val getPlaneTypeByCategoryUseCase: GetPlaneTypeByCategoryUseCase
) : ModelRepository {

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun getModels(category: Category): Flow<PagingData<Product>> =
        Pager(
            config = PagingConfig(
                pageSize = 24
            ),
            remoteMediator = ModelRemoteMediator(
                category,
                networkDataSource,
                database,
                getPlaneTypeByCategoryUseCase
            ),
            pagingSourceFactory = {
                categoryAndProductDao.getProductsByCategory(category)
            }
        ).flow.map { it.map(ProductEntity::asExternalModel) }

    override fun getCategories(): List<Category> = localDataSource.getCategories()

    override suspend fun getProductCategory(productId: String): CategoryInfo {
        val localInfo = localDataSource.getProductCategory(productId)?.asExternalModel()
        if (localInfo != null) {
            return localInfo
        }

        // If model can not be found in database, fetch from network
        networkDataSource.getModelInfo(productId).let { result ->
            if (result is ApiSuccess) {
                val category =
                    result.data.tags.firstNotNullOfOrNull { Category.valueOrNull(it.slug) }
                        ?: Category.TABLE
                val planeType = getPlaneTypeByCategoryUseCase(category)
                return CategoryInfo(category, planeType)
            }
            // Use unknown category as default value when failed to get model data from remote
            return Category.UNKNOWN.let { CategoryInfo(it, getPlaneTypeByCategoryUseCase(it)) }
        }
    }

    override suspend fun getDownloadInfo(modelId: String): Flow<Result<DownloadInfo>> = flow {
        emit(Result.Loading)

        val result = withContext(Dispatchers.IO) {
            networkDataSource.getDownloadInfo(modelId)
        }

        when (result) {
            is ApiSuccess -> {
                val downloadInfo = result.data.glb.asExternalModel()
                emit(Result.Success(downloadInfo))
            }

            is ApiError -> emit(Result.Error(Exception(result.message)))
            is ApiException -> emit(Result.Error(Exception(result.exception)))
        }
    }

    override suspend fun download(path: Path, url: String): Flow<DownloadStatus> =
        networkDataSource.downloadModel(path, url)
}
