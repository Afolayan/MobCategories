package com.afolayanseyi.mobcategories.utils

import android.widget.ImageView
import com.afolayanseyi.mobcategories.R
import com.bumptech.glide.Glide

class GlideImageLoader : ImageLoader {

    override fun loadImage(imageView: ImageView, url: String) {

        val imageUrl = baseUrl.plus(url)
        Glide.with(imageView)
            .load(imageUrl)
            .error(R.drawable.ic_empty_product)
            .placeholder(R.drawable.ic_empty_product)
            .into(imageView)

    }

}