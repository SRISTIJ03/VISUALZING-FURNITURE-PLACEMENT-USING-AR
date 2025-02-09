package com.Sristi.AR_Furniture_Placement.utils.extension

import android.content.Context
import android.net.Uri
import androidx.core.app.ShareCompat
import com.Sristi.AR_Furniture_Placement.utils.constant.Constants

/**
 * Share image with the intent chooser.
 *
 * @param uri The content uri to share. (e.g. Uri for bitmap data)
 * @param text The description or caption to add with sharing.
 */
fun Context.shareImage(uri: Uri, text: String) {
    ShareCompat.IntentBuilder(this)
        .setText(text)
        .setStream(uri)
        .setType(Constants.IMAGE_TYPE)
        .startChooser()
}
