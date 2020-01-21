package com.afolayanseyi.mobcategories.data

import com.afolayanseyi.mobcategories.network.NetworkApi
import com.afolayanseyi.mobcategories.utils.testCategory
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class MobCategoriesRepositoryImplTest {

    lateinit var repositoryImpl: MobCategoriesRepositoryImpl
    private val networkApi: NetworkApi = mock()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(mainThreadSurrogate)

        repositoryImpl = MobCategoriesRepositoryImpl(networkApi)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }


    @Test
    fun test_fetchCategories_forSuccess(){
        runBlocking {
            launch(Dispatchers.Main) {
                val expectedResult = async { listOf(testCategory) }

                whenever(networkApi.fetchMobCategories()).thenReturn(expectedResult)

                val mobCategoriesAsync = repositoryImpl.getMobCategoriesAsync()

               verify(networkApi).fetchMobCategories()

                assert(mobCategoriesAsync.isCompleted)
            }
        }
    }
}