package com.afolayanseyi.mobcategories.model

data class MobCategory(
    var id: String? = null,
    var name: String? = null,
    var description: String? = null,
    var products: List<Product> = listOf()
)

data class Product(
    var id: String? = null,
    var categoryId: String? = null,
    var name: String? = null,
    var url: String? = null,
    var description: String? = null,
    var salePrice: SalePrice? = null

)

data class SalePrice(
    var amount: String? = null,
    var currency: String? = null
)
