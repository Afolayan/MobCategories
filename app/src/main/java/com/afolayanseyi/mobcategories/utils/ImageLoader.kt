package com.afolayanseyi.mobcategories.utils

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(imageView: ImageView, url: String)
}