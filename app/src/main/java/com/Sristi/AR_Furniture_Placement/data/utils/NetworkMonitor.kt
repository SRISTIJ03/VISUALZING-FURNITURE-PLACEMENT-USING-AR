package com.Sristi.AR_Furniture_Placement.data.utils

import kotlinx.coroutines.flow.Flow

/**
 * Utility for reporting app connectivity status
 */
interface NetworkMonitor {

    val isOnline: Flow<Boolean>
}
