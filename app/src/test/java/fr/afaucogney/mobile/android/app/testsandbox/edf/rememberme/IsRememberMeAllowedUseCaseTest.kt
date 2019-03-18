package fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme

import android.test.mock.MockContext
import fr.afaucogney.mobile.android.app.testsandbox.application.TestStandboxApplication
import io.mockk.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class IsRememberMeAllowedUseCaseTest {



    /**
     *
     * Mock framework : mockk https://github.com/mockk/mockk
     * MockContext : https://developer.android.com/reference/android/test/mock/MockContext
     */

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun test1() {
        // Given
        mockkStatic(TestStandboxApplication.Companion::class)
        every { TestStandboxApplication.applicationContext() } returns MockContext()

        val cf = mockk<IsRememberMeAllowedUseCase.Companion.AppConfiguration>()
        mockkStatic(IsRememberMeAllowedUseCase.Companion.AppConfiguration::class)
        every { IsRememberMeAllowedUseCase.Companion.AppConfiguration.readConfiguration(any()) } returns cf
        every { cf.is_se_souvenir_de_moi_active } returns true

        mockkStatic(IsRememberMeAllowedUseCase.Companion.RootDetector::class)
        every { IsRememberMeAllowedUseCase.Companion.RootDetector.isDeviceRooted(any()) } returns true

        mockkStatic(IsRememberMeAllowedUseCase.Companion.LockSecurityDetector::class)
        every { IsRememberMeAllowedUseCase.Companion.LockSecurityDetector.doesDeviceHaveSecuritySetup(any()) } returns true

        mockkObject(IsRememberMeAllowedUseCase.Companion.TestHelper)
        every { IsRememberMeAllowedUseCase.Companion.TestHelper.atLeastLollipop() } returns true

        // When
        val result = IsRememberMeAllowedUseCase().execute()

        // Then
        val expectedResult = false
        assertThat(result).isEqualTo(expectedResult)
    }

    @After
    fun teardown() {
        clearAllMocks()
    }
}