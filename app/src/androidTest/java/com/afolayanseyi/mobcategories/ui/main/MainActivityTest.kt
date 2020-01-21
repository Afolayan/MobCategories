package com.afolayanseyi.mobcategories.ui.main

import android.view.View
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import androidx.test.rule.ActivityTestRule
import com.afolayanseyi.mobcategories.R
import junit.framework.Assert.assertNotNull
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.Matchers.greaterThan
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@MediumTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var rule = ActivityTestRule(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun ensureRecyclerViewIsPresent() {
        val activity = rule.activity
        launchFragmentInContainer<ProductListFragment>()
        val viewById: View = activity.findViewById(R.id.recycler)
        assertThat(viewById, notNullValue())
        assertThat(viewById, instanceOf(RecyclerView::class.java))
        val recyclerView: RecyclerView = viewById as RecyclerView
        assertNotNull(recyclerView)

        //wait till list is loaded
        Thread.sleep(10000)

        val adapter: RecyclerView.Adapter<*>? = recyclerView.adapter
        assertThat(adapter, instanceOf(RecyclerView.Adapter::class.java))

        //confirm that the list of categories is more than 1
        assertThat(adapter!!.itemCount, greaterThan(1))
    }
}