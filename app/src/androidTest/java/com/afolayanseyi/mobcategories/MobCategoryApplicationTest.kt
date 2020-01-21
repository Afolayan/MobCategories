package com.afolayanseyi.mobcategories

import android.content.pm.PackageInfo
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.afolayanseyi.mobcategories.app.MobCategoryApplication
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern


@RunWith(AndroidJUnit4::class)
class MobCategoryApplicationTest {
    private lateinit var application: MobCategoryApplication

    @Before
    @Throws(Exception::class)
    fun setUp() {
        application = MobCategoryApplication()
    }

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.afolayanseyi.mobcategories", appContext.packageName)
    }

    @Throws(Exception::class)
    fun testCorrectVersion() {
        val info: PackageInfo =
            application.packageManager.getPackageInfo(application.packageName, 0)
        assertNotNull(info)
        assertTrue(Pattern.matches("\\d\\.\\d", info.versionName))
    }

}
