package fr.afaucogney.mobile.android.app.testsandbox.extFunction

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.verifySequence
import org.junit.Test
import java.util.*


class StringFormatUseCaseTest {

    @Test
    fun t1() {
        val result = StringFormatUseCase().execute(true)
        println(result)
    }

    @Test
    fun t2() {

        mockkObject(String)
        every { String.format(any<Locale>(), any(), any()) } returns ""

        val result = StringFormatUseCase().execute(false)
        println(result)

        verifySequence {
            String.format(any<Locale>(), any(), any()) // java.lang.NullPointerException
        }
    }

}