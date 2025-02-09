package com.Sristi.AR_Furniture_Placement.data.local.database.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.Sristi.AR_Furniture_Placement.data.model.Category
import com.Sristi.AR_Furniture_Placement.data.model.CategoryInfo
import com.Sristi.AR_Furniture_Placement.data.model.PlaneType
import com.Sristi.AR_Furniture_Placement.utils.constant.Constants

@Entity(
    tableName = Constants.TABLE_CATEGORY,
    indices = [
        Index(value = ["category"], unique = true)
    ]
)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val category: Category,
    val planeType: PlaneType
)

fun CategoryInfo.asEntity() = CategoryEntity(category = category, planeType = planeType)
