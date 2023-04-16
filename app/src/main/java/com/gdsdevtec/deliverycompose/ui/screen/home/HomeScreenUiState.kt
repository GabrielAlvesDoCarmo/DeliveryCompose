package com.gdsdevtec.deliverycompose.ui.screen.home

import com.gdsdevtec.deliverycompose.model.Product

data class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchProducts: List<Product> = emptyList(),
    val searchValue: String = "",
    val onSearchChange: (String) -> Unit = {},
) {
    fun isShowSections() = searchValue.isBlank()
}