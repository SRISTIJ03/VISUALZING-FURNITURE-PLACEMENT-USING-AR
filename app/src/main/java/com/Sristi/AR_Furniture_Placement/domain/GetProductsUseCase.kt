package com.Sristi.AR_Furniture_Placement.domain

import androidx.paging.PagingData
import com.Sristi.AR_Furniture_Placement.data.model.Category
import com.Sristi.AR_Furniture_Placement.data.model.Product
import com.Sristi.AR_Furniture_Placement.data.repository.ModelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val modelRepository: ModelRepository,
) {

    suspend operator fun invoke(category: Category): Flow<PagingData<Product>> =
        modelRepository.getModels(category)
}
