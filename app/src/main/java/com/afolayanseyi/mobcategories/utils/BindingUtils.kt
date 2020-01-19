package com.afolayanseyi.mobcategories.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.afolayanseyi.mobcategories.data.model.SalePrice

@BindingAdapter("productImage")
fun loadImage(imageView: ImageView, url: String) {
    GlideImageLoader().loadImage(imageView, url)
}

@BindingAdapter("price")
fun loadPrice(priceTextView: TextView, salePrice: SalePrice) =  salePrice.run {
    priceTextView.text = joinCurrencyAndAmount()
}