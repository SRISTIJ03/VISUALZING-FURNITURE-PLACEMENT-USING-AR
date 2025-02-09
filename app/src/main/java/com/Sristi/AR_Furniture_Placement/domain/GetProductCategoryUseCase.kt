package com.Sristi.AR_Furniture_Placement.domain

import com.Sristi.AR_Furniture_Placement.data.model.CategoryInfo
import com.Sristi.AR_Furniture_Placement.data.repository.ModelRepository
import javax.inject.Inject

class GetProductCategoryUseCase @Inject constructor(
    private val modelRepository: ModelRepository,
) {

    suspend operator fun invoke(productId: String): CategoryInfo =
        modelRepository.getProductCategory(productId)
}
