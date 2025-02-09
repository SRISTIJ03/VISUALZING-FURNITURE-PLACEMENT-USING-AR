package com.Sristi.AR_Furniture_Placement.utils.extension

import com.google.android.filament.MaterialInstance
import io.github.sceneview.node.ModelNode

/**
 * Make deep clone of [MaterialInstance] present in [ModelNode]
 */
fun <T : MaterialInstance> List<List<T>>.clone() =
    map { materials ->
        materials.map { material -> MaterialInstance.duplicate(material, material.name) }
    }
