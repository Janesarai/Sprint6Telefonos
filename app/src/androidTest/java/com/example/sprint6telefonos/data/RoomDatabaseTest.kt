package com.example.sprint6telefonos.data

    import android.content.Context
    import androidx.annotation.VisibleForTesting
    import androidx.arch.core.executor.testing.InstantTaskExecutorRule
    import androidx.lifecycle.LiveData
    import androidx.lifecycle.Observer
    import androidx.room.Room
    import androidx.test.core.app.ApplicationProvider
    import com.example.sprint6telefonos.data.local.FonoDAO
    import com.example.sprint6telefonos.data.local.FonoDataBase
    import com.example.sprint6telefonos.data.local.FonoEntity
    import com.google.common.truth.Truth
    import kotlinx.coroutines.runBlocking
    import org.junit.After
    import org.junit.Before
    import org.junit.Rule
    import org.junit.Test
    import java.util.concurrent.CountDownLatch
    import java.util.concurrent.TimeUnit
    import java.util.concurrent.TimeoutException

    //test unitario
    class RoomDatabaseTest {

        @get:Rule
        var instantExecutorRule = InstantTaskExecutorRule()

        private lateinit var fonoDao: FonoDAO
        private lateinit var db: FonoDataBase

        @Before
        fun setUp() {
            val context = ApplicationProvider.getApplicationContext<Context>()
            db = Room.inMemoryDatabaseBuilder(context, FonoDataBase::class.java).build()
            fonoDao = db.getFonoDao()
        }

        @After
        fun tearDown() {
            db.close()
        }

        @Test
        fun insertPhone_hapSipyCase_1element() = runBlocking {
            // Given
            val fonoData = FonoEntity(87,"prueba", 7568, "noimg")

            // When
            fonoDao.insertFono(fonoData)

            // Then
            fonoDao.getFonos().observeForever {
                Truth.assertThat(it).isNotNull()
                Truth.assertThat(it).isNotEmpty()
                Truth.assertThat(it).hasSize(1)
            }
        }


    }


    @VisibleForTesting(otherwise = VisibleForTesting.NONE)
    fun <T> LiveData<T>.getOrAwaitValue(
        time: Long = 2,
        timeUnit: TimeUnit = TimeUnit.SECONDS,
        afterObserve: () -> Unit = {}
    ): T {
        var data: T? = null
        val latch = CountDownLatch(1)
        val observer = object : Observer<T> {
            override fun onChanged(value: T) {
                data = value
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }
        this.observeForever(observer)

        try {
            afterObserve.invoke()

            if (!latch.await(time, timeUnit)) {
                throw TimeoutException("LiveData value was never set.")
            }

        } finally {
            this.removeObserver(observer)
        }

        @Suppress("UNCHECKED_CAST")
        return data as T


    }


