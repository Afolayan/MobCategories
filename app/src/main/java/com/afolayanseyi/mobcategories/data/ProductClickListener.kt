package com.afolayanseyi.mobcategories.data

import com.afolayanseyi.mobcategories.data.model.Product

interface ProductClickListener {
    fun onProductClick(product: Product)
}