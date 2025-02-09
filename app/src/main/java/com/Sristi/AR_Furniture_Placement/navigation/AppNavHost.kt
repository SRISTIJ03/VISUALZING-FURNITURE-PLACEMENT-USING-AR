package com.Sristi.AR_Furniture_Placement.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.Sristi.AR_Furniture_Placement.ui.AppState
import com.Sristi.AR_Furniture_Placement.ui.arview.navigation.arViewScreen
import com.Sristi.AR_Furniture_Placement.ui.arview.navigation.navigateToARView
import com.Sristi.AR_Furniture_Placement.ui.download.navigation.downloadScreen
import com.Sristi.AR_Furniture_Placement.ui.download.navigation.navigateToDownload
import com.Sristi.AR_Furniture_Placement.ui.products.navigation.PRODUCTS_ROUTE
import com.Sristi.AR_Furniture_Placement.ui.products.navigation.navigateToProducts
import com.Sristi.AR_Furniture_Placement.ui.products.navigation.productsScreen
import timber.log.Timber

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    appState: AppState,
    startDestination: String = PRODUCTS_ROUTE,
    onShowSnackbar: suspend (String, String?) -> Boolean
) {

    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        productsScreen { productId ->
            Timber.d("Clicked: $productId")
            navController.navigateToDownload(productId)
        }

        downloadScreen { productId, _, color ->
            navController.navigateToARView(productId, color)
        }

        arViewScreen(
            onNavigateBack = { navController.navigateToProducts() },
            onShowSnackbar = onShowSnackbar
        )
    }
}
