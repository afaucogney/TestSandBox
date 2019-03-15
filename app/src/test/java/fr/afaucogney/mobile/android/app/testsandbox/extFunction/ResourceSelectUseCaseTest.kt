package fr.afaucogney.mobile.android.app.testsandbox.extFunction

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(
    manifest = Config.NONE
)
@RunWith(RobolectricTestRunner::class)
class ResourceSelectUseCaseTest {

    @Test
    fun t1() {
        assertEquals(ResourceSelectUseCase(RuntimeEnvironment.application).execute(true), "TestSandBox")
    }

    @Test
    fun t2() {
        assertEquals(ResourceSelectUseCase(RuntimeEnvironment.application).execute(false), "TestSandBox Fake")
    }

    fun fdsfd(): Unit {
        // Given

        // When

        // Then



    }

    @Test
    fun test() {

    }

}