package com.afolayanseyi.mobcategories.ui.main

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.afolayanseyi.mobcategories.R
import com.afolayanseyi.mobcategories.utils.PRODUCT_ARGS_EXTRA
import com.afolayanseyi.mobcategories.utils.testProduct
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProductDetailFragmentTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        val fragmentArgs = Bundle().apply {
            putParcelable(PRODUCT_ARGS_EXTRA, testProduct)
        }

        launchFragmentInContainer<ProductDetailFragment>(fragmentArgs = fragmentArgs)
    }

    @Test
    fun testProductDetailFragment() {

        onView(withId(R.id.productImageView)).check(matches(isDisplayed()))
        onView(withId(R.id.productNameTextView)).check(matches(withText(testProduct.name)))
        onView(withId(R.id.productPriceTextView)).check(matches(withText(testProduct.salePrice!!.joinCurrencyAndAmount())))
    }


    @Test
    fun productDetailsFragment_mainViewsPresent() {

        onView(withId(R.id.productImageView)).check(matches(isDisplayed()))
        onView(withId(R.id.productNameTextView)).check(matches(isDisplayed()))
        onView(withId(R.id.productPriceTextView)).check(matches(isDisplayed()))

    }
}