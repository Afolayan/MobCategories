package com.afolayanseyi.mobcategories.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class MobCategory(
    var id: String? = null,
    var name: String? = null,
    var description: String? = null,
    var products: List<Product> = listOf()
)

@Parcelize
data class Product(
    var id: String? = null,
    var categoryId: String? = null,
    var name: String? = null,
    var url: String? = null,
    var description: String? = null,
    var salePrice: SalePrice? = null

): Parcelable

@Parcelize
data class SalePrice(
    var amount: String? = null,
    var currency: String? = null
): Parcelable
