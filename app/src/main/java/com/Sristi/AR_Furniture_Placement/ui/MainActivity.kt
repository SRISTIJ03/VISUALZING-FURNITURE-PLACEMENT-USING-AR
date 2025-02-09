package com.Sristi.AR_Furniture_Placement.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.Sristi.AR_Furniture_Placement.data.utils.NetworkMonitor
import com.Sristi.AR_Furniture_Placement.ui.theme.SSFurniCraftARTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val appState = rememberAppState(
                networkMonitor = networkMonitor
            )

            SSFurniCraftARTheme {
                SSFurniCraftARApp(appState)
            }
        }
    }
}
