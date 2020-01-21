package com.afolayanseyi.mobcategories

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.afolayanseyi.mobcategories.ui.main.ProductListFragment
import org.hamcrest.CoreMatchers.not
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProductListFragmentTest {

    @Test
    fun testProductListFragmentHasRecyclerView() {
        launchFragmentInContainer<ProductListFragment>()
        onView(withId(R.id.recycler)).check(matches(isDisplayed()))
    }

    @Test
    fun testProductListFragmentHasProgressBar() {
        launchFragmentInContainer<ProductListFragment>()
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
    }

    @Test
    fun testHasProgressBar_canDismissAfterListIsLoaded() {
        launchFragmentInContainer<ProductListFragment>()
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))

        Thread.sleep(5000)

        onView(withId(R.id.progressBar)).check(matches(not(isDisplayed())))
    }
}