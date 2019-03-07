package fr.afaucogney.mobile.android.app.testsandbox.extFunction

import io.mockk.*
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
        mockkObject(String.Companion)
        every { String.format(any<Locale>(), any(), any()) } returns ""

        val result = StringFormatUseCase().execute(false)
        println(result)

        verifySequence {
            String.format(any<Locale>(), any(), any()) // java.lang.NullPointerException
        }
        confirmVerified(String)
    }

    @Test
    fun t3() {
        mockkStatic("kotlin.text.StringsKt")
        every { String.format(any<Locale>(), any(), any()) } returns ""

        val result = StringFormatUseCase().execute(false)
        println(result)

        verifySequence {
            String.format(any<Locale>(), any(), any()) // java.lang.NullPointerException
        }
        confirmVerified(String)
    }

    @Test
    fun t4() {
        mockkStatic(java.lang.String::class)
        every { java.lang.String.format(any<Locale>(), any(), any()) } returns ""

        val result = StringFormatUseCase().execute(false)
        println(result)

        verifySequence {
            java.lang.String.format(any<Locale>(), any(), any()) // java.lang.NullPointerException
        }
    }
}