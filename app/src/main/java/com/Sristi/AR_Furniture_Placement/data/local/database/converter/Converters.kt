package com.Sristi.AR_Furniture_Placement.data.local.database.converter

import androidx.room.TypeConverter
import com.Sristi.AR_Furniture_Placement.data.model.Category


/**
 * Converters b/w database entities and models.
 */
class Converters {

    /**
     * Get database compatible value from [Category]
     *
     * @param value The category to convert
     */
    @TypeConverter
    fun fromCategory(value: Category?) = value?.slug

    /**
     * Get [Category] from database value
     *
     * @param value The value to convert
     */
    @TypeConverter
    fun toCategory(value: String) = Category.valueOrNull(value)
}
