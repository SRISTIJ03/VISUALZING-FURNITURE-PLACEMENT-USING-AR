package com.Sristi.AR_Furniture_Placement.domain

import com.Sristi.AR_Furniture_Placement.data.model.DownloadInfo
import com.Sristi.AR_Furniture_Placement.data.repository.ModelRepository
import com.Sristi.AR_Furniture_Placement.utils.result.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDownloadInfoUseCase @Inject constructor(
    private val modelRepository: ModelRepository,
) {

    suspend operator fun invoke(productId: String): Flow<Result<DownloadInfo>> =
        modelRepository.getDownloadInfo(productId)
}
