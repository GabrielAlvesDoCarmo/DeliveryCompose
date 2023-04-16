package com.gdsdevtec.deliverycompose.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gdsdevtec.deliverycompose.sample.*
import com.gdsdevtec.deliverycompose.ui.components.CardProductItem
import com.gdsdevtec.deliverycompose.ui.components.ProductSection2
import com.gdsdevtec.deliverycompose.ui.components.ProductSectionShop
import com.gdsdevtec.deliverycompose.ui.components.SearchBar

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel
) {
    val stateHome by viewModel.uiState.collectAsState()
    HomeScreen(state = stateHome)
}

@Composable
fun HomeScreen(
    state: HomeScreenUiState = HomeScreenUiState(),
) = Column {
    val sections = state.sections
    val text = state.searchValue
    val searchProducts = state.searchProducts

    SearchBar(
        searchValue = text,
        onChangeValue = state.onSearchChange,
        modifier = Modifier.padding(horizontal = 16.dp)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        item {
            Spacer(modifier = Modifier)
        }
        if (state.isShowSections()) {
            for (sec in sections) {
                val title = sec.key
                val products = sec.value
                item { ProductSection2(title = title, products = products) }
            }
            for (shop in sampleShopSections) item {
                ProductSectionShop(title = "Outras Lojas", shop = shop.value)
            }
        } else items(searchProducts) { product ->
            CardProductItem(
                product = product,
                Modifier.padding(16.dp)
            )
        }
        item {
            Spacer(modifier = Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() = HomeScreen(
    state = HomeScreenUiState(
        sections = sampleSections,
        searchValue = "a"
    )
)

@Preview(showBackground = true)
@Composable
private fun HomeScreenSearchValuePreview() = HomeScreen(
    viewModel = HomeScreenViewModel()
)
