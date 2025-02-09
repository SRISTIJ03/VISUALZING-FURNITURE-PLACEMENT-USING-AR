package com.Sristi.AR_Furniture_Placement.utils.extension

import io.github.sceneview.math.Color as SVColor
import androidx.compose.ui.graphics.Color as ComposeColor

/**
 * Convert [ComposeColor] to [SVColor]
 *
 * @return Returns converted [SVColor]
 */
fun ComposeColor.toSVColor(): SVColor {
    val (r, g, b, a) = this
    return SVColor(r, g, b, a)
}
