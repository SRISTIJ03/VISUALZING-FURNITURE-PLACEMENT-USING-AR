package com.Sristi.AR_Furniture_Placement.domain

import com.Sristi.AR_Furniture_Placement.data.model.Category
import com.Sristi.AR_Furniture_Placement.data.repository.ModelRepository
import javax.inject.Inject

class GetProductCategoriesUseCase @Inject constructor(
    private val modelRepository: ModelRepository
) {

    operator fun invoke(): List<Category> = modelRepository.getCategories()
}
