package com.gdsdevtec.deliverycompose.sample

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.gdsdevtec.deliverycompose.model.Product
import com.gdsdevtec.deliverycompose.model.Shop

val sampleCandies = listOf(
    Product(
        name = "Chocolate",
        price = "3.99".toBigDecimal(),
        image = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg",
        description = LoremIpsum(50).values.toString()
    ),
    Product(
        name = "Sorvete",
        price = "5.99".toBigDecimal(),
        image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
        description = LoremIpsum(50).values.toString()
    ),
    Product(
        name = "Bolo",
        price = "11.99".toBigDecimal(),
        image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
        description = LoremIpsum(50).values.toString()
    )
)

val sampleDrinks = listOf(
    Product(
        name = "Cerveja",
        price = "5.99".toBigDecimal(),
        image = "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",
        description = LoremIpsum(50).values.toString()
    ),
    Product(
        name = "Refrigerante",
        price = "4.99".toBigDecimal(),
        image = "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg",
        description = LoremIpsum(50).values.toString()
    ),
    Product(
        name = "Suco",
        price = "7.99".toBigDecimal(),
        image = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg",
        description = LoremIpsum(50).values.toString()
    ),
    Product(
        name = "Água",
        price = "2.99".toBigDecimal(),
        image = "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg",
        description = LoremIpsum(50).values.toString()
    )
)

val sampleProducts: List<Product> = listOf(
    Product(
        name = "Hamburguer",
        price = "12.99".toBigDecimal(),
        image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg",
        description = LoremIpsum(150).values.toString()

    ),
    Product(
        name = "Pizza",
        price = "19.99".toBigDecimal(),
        image = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg",
    ),
    Product(
        name = "Batata frita",
        price = "7.99".toBigDecimal(),
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg",
    ), *sampleDrinks.toTypedArray(), *sampleCandies.toTypedArray()
)
val sampleShops: List<Shop> = listOf(
    Shop(
        name = "Carrinho SuperMercado",
        logo = "https://images.pexels.com/photos/264547/pexels-photo-264547.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
    Shop(
        name = "Padaria",
        logo = "https://images.pexels.com/photos/1855214/pexels-photo-1855214.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
    Shop(
        name = "Floricultura",
        logo = "https://images.pexels.com/photos/2111192/pexels-photo-2111192.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
    Shop(
        name = "Loja de Roupas",
        logo = "https://images.pexels.com/photos/102129/pexels-photo-102129.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
    Shop(
        name = "Hotéis",
        logo = "https://images.pexels.com/photos/237272/pexels-photo-237272.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    ),
)
val sampleSections = mapOf(
    "Promoções" to sampleProducts,
    "Doces" to sampleCandies,
    "Bebidas" to sampleDrinks,
)

val sampleShopSections = mapOf(
    "Lojas Parceiras" to sampleShops
)