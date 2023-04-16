package com.gdsdevtec.deliverycompose.dao

import com.gdsdevtec.deliverycompose.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDao {
    companion object{
//        private val products = mutableStateListOf(*sampleProducts.toTypedArray())
        private val products = MutableStateFlow<List<Product>>(emptyList())
    }
    fun products() = products.asStateFlow()
    fun saveProduct(product: Product)  {
        products.value = products.value + product
    }
}