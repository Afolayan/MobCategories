package com.afolayanseyi.mobcategories.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.afolayanseyi.mobcategories.R
import com.afolayanseyi.mobcategories.data.model.Product
import com.afolayanseyi.mobcategories.databinding.FragmentProductDetailBinding
import com.afolayanseyi.mobcategories.utils.PRODUCT_ARGS_EXTRA


class ProductDetailFragment : Fragment() {
    private lateinit var fragmentProductDetailBinding: FragmentProductDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentProductDetailBinding =
            DataBindingUtil.inflate(inflater,
                R.layout.fragment_product_detail,
                container,
                false)

        return fragmentProductDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val product = it.getParcelable<Product>(PRODUCT_ARGS_EXTRA)!!
            fragmentProductDetailBinding.product = product
        }
    }
}
