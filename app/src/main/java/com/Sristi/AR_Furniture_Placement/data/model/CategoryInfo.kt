package com.Sristi.AR_Furniture_Placement.data.model

import com.Sristi.AR_Furniture_Placement.data.local.database.model.CategoryEntity

data class CategoryInfo(
    val category: Category,
    val planeType: PlaneType
)

fun CategoryEntity.asExternalModel() = CategoryInfo(
    category = category,
    planeType = planeType
)
