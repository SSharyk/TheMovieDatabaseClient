package free.ssharyk.themoviedatabaseclient.features.popular

import free.ssharyk.themoviedatabaseclient.domain.Movie
import free.ssharyk.themoviedatabaseclient.domain.MovieType
import free.ssharyk.themoviedatabaseclient.features.popular.interactor.GetPopular
import free.ssharyk.themoviedatabaseclient.features.popular.interactor.GetPopularUseCaseImpl
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetPopularTests {

    private val testScope = TestScope(UnconfinedTestDispatcher())
    private lateinit var subject: GetPopular

    @Before
    fun setup() {
        val fakeNetworkLoader = FakeNetworkLoader()
        subject = GetPopularUseCaseImpl(fakeNetworkLoader)
    }

    @Test
    fun `when load several movies of different type then flow emits values`() = testScope.runTest {
        val expected = listOf(
            Movie("11", MovieType.FILM, "Movie1", "descr1", 2000, ""),
            Movie("222", MovieType.SERIES, "Series2", "descr2", 2022, "http://google.com/favicon")
        )
        val actual = subject.loadPopular().first()
        assertEquals(expected, actual)
    }

}