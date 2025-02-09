package com.Sristi.AR_Furniture_Placement.ui.products.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.Sristi.AR_Furniture_Placement.ui.products.ProductsRoute

const val PRODUCTS_ROUTE = "products_route"

fun NavController.navigateToProducts() {
    navigate(PRODUCTS_ROUTE)
}

fun NavGraphBuilder.productsScreen(onProductClick: (String) -> Unit) {
    composable(
        route = PRODUCTS_ROUTE
    ) {
        ProductsRoute(onProductClick = onProductClick)
    }
}
