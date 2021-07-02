package activities

import android.content.Context
import com.example.retrofitsample.Api
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import retrofit2.Response

@org.junit.runner.RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    @Mock
    private lateinit var mApi: Api

    @Mock
    private lateinit var mockContext: Context

    @Before
    fun setUp() {
        whenever((view).context()).thenReturn(mockContext)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun testGetHeroList() {

    }
}