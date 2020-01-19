package com.afolayanseyi.mobcategories.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.afolayanseyi.mobcategories.LiveDataTestUtil
import com.afolayanseyi.mobcategories.data.MobCategoriesRepositoryImpl
import com.afolayanseyi.mobcategories.data.model.Result
import com.afolayanseyi.mobcategories.utils.testCategory
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.mockito.MockitoAnnotations

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
class ProductListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val mobCategoriesRepository: MobCategoriesRepositoryImpl = mock()
    private lateinit var viewModel: ProductListViewModel

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(mainThreadSurrogate)
        viewModel = ProductListViewModel(mobCategoriesRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun test_retrieveSummaryData() {
        viewModel.getMobCategories()

        Assert.assertNotNull(viewModel.mobCategoriesLiveData)
    }

    @Test
    fun testViewModel_getMobCategories_forSuccess() {
        runBlocking {
            launch(Dispatchers.Main) {
                val expectedResult = async { listOf(testCategory) }
                whenever(mobCategoriesRepository.getMobCategoriesAsync()).thenReturn(expectedResult)

                viewModel.getMobCategories()

                // wait till loading is over
                delay(1000)
                val liveDataValue = LiveDataTestUtil.getValue(viewModel.mobCategoriesLiveData)

                Assert.assertNotNull(liveDataValue)
                Assert.assertEquals(liveDataValue, Result.Success(listOf(testCategory)))
            }

        }
    }


    @Test
    fun testViewModel_loading() {
        runBlocking {
            launch(Dispatchers.Main) {
                viewModel.getMobCategories()

                val liveDataValue = LiveDataTestUtil.getValue(viewModel.mobCategoriesLiveData)

                Assert.assertNotNull(liveDataValue)
                Assert.assertEquals(liveDataValue, Result.Loading)
            }

        }
    }
}