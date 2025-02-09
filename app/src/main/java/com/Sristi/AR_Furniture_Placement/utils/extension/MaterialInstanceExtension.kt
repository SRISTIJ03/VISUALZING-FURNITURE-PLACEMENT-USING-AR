package com.Sristi.AR_Furniture_Placement.utils.extension

import com.google.android.filament.MaterialInstance
import com.Sristi.AR_Furniture_Placement.utils.constant.Constants
import io.github.sceneview.material.setBaseColorFactor
import io.github.sceneview.material.setBaseColorIndex
import io.github.sceneview.math.Color

/**
 * Set color on material instances
 *
 * @param color The new color to set on model
 */
fun List<List<MaterialInstance>>.setColor(color: Color) {
    flatten().forEach { instance ->
        instance.setBaseColorIndex(Constants.MODEL_BASE_COLOR_INDEX)
        instance.setBaseColorFactor(color)
    }
}
