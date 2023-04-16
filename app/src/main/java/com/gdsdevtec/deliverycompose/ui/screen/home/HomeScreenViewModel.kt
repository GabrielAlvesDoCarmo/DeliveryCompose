package com.gdsdevtec.deliverycompose.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdsdevtec.deliverycompose.dao.ProductDao
import com.gdsdevtec.deliverycompose.model.Product
import com.gdsdevtec.deliverycompose.sample.sampleCandies
import com.gdsdevtec.deliverycompose.sample.sampleDrinks
import com.gdsdevtec.deliverycompose.sample.sampleProducts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val dao: ProductDao = ProductDao()
    private val _uiState: MutableStateFlow<HomeScreenUiState> = MutableStateFlow(
        HomeScreenUiState()
    )
    val uiState get() = _uiState.asStateFlow()



    init {
        _uiState.update { currentState->
            currentState.copy(
                onSearchChange = {
                    _uiState.value = _uiState.value.copy(
                        searchValue = it,
                        searchProducts = searchProducts(it)
                    )
                }
            )
        }
        viewModelScope.launch {
            dao.products().collect { products ->
                _uiState.value = _uiState.value.copy(
                    sections = mapOf(
                        "Todos" to products,
                        "Promocoes" to sampleDrinks + sampleCandies,
                        "doces" to sampleCandies,
                        "bebidas" to sampleDrinks
                    ),
                    searchProducts = searchProducts(_uiState.value.searchValue)
                )
            }
        }
    }

    private fun nameOrDescription(text: String) = { product: Product ->
        product.name.contains(text, true) ||
                product.description?.contains(text, true) ?: false
    }

    private fun searchProducts(text: String) = if (text.isNotEmpty()) {
        dao.products().value.filter(nameOrDescription(text)) +
                sampleProducts
                    .filter(nameOrDescription(text))
    } else emptyList()
}