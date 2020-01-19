package com.afolayanseyi.mobcategories.utils

import com.afolayanseyi.mobcategories.data.model.MobCategory
import com.afolayanseyi.mobcategories.data.model.Product
import com.afolayanseyi.mobcategories.data.model.SalePrice

val testProduct: Product
    get() = Product(
        id = "1",
        categoryId = "36802",
        name = "Bread",
        url = "/Bread.jpg",
        description = "",
        salePrice = salePrice
    )

val salePrice = SalePrice (
    amount = "0.81",
    currency = "EUR"
)


val testCategory = MobCategory (
    id = "36802",
    name = "Food",
    description = "",
    products = listOf(testProduct)
)

