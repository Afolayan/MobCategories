package com.afolayanseyi.mobcategories.utils

import android.widget.ImageView
import com.afolayanseyi.mobcategories.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class GlideImageLoader : ImageLoader {

    override fun loadImage(imageView: ImageView, url: String) {

        val imageUrl = BASE_API_URL.plus(url)
        Glide.with(imageView)
            .load(imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .error(R.drawable.ic_empty_product)
            .placeholder(R.drawable.ic_empty_product)
            .into(imageView)

    }

}