package com.gdsdevtec.deliverycompose.ui.screen.form

import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.gdsdevtec.deliverycompose.dao.ProductDao
import com.gdsdevtec.deliverycompose.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal
import java.text.DecimalFormat

class ProductFormScreenViewModel : ViewModel() {
    private val dao = ProductDao()


    private val _uiState: MutableStateFlow<ProductFormScreenUiState> = MutableStateFlow(
        ProductFormScreenUiState()
    )
    val uiState get() = _uiState.asStateFlow()

    private val formatter = DecimalFormat("#.##")


    init {
        _uiState.update { currentState ->
            currentState.copy(
                onUrlChange = { safeUrl ->
                    _uiState.value = _uiState.value.copy(
                        url = safeUrl,
                    )
                },
                onNameChange = { safeName ->
                    _uiState.value = _uiState.value.copy(
                        name = safeName
                    )
                },
                onPriceChange = { safePrice ->
                    val price = try {
                        formatter.format(safePrice.toBigDecimal())
                    } catch (e: IllegalArgumentException) {
                        if (safePrice.isBlank()) safePrice else null
                    }
                    price?.let { value ->
                        _uiState.value = _uiState.value.copy(
                            price = value
                        )
                    }
                },
                onDescriptionChange = { safeDescription ->
                    _uiState.value = _uiState.value.copy(
                        description = safeDescription
                    )
                }
            )
        }
    }
    fun save() {
        _uiState.value.run {
            val convertedPrice = try {
                price.toBigDecimal()
            } catch (e: NumberFormatException) {
                BigDecimal.ZERO
            }
            val product = Product(
                name = name,
                image = url,
                price = convertedPrice,
                description = description
            )
            dao.saveProduct(product)
        }
    }
}