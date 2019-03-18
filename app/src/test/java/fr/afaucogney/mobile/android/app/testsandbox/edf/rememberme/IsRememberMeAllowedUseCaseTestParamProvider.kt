package fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme

import android.test.mock.MockContext
import fr.afaucogney.mobile.android.app.testsandbox.application.TestStandboxApplication
import io.mockk.*
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class IsRememberMeAllowedUseCaseTestParamProvider {

    /**
     *
     * Link : https://github.com/Pragmatists/JUnitParams
     */


    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    @Parameters(source = PhoneSetupParamProvider::class)
    fun test2(
        seSouvernirDeMoi: Boolean,
        isRooted: Boolean,
        hasSecuritySetup: Boolean,
        isAtLeastLollipop: Boolean,
        expectedResult: Boolean
    ) {

        // Given
        mockkStatic(TestStandboxApplication::class)
        every { TestStandboxApplication.applicationContext() } returns MockContext()

        val cf = mockk<IsRememberMeAllowedUseCase.Companion.AppConfiguration>()
        mockkStatic(IsRememberMeAllowedUseCase.Companion.AppConfiguration::class)
        every { IsRememberMeAllowedUseCase.Companion.AppConfiguration.readConfiguration(any()) } returns cf
        every { cf.is_se_souvenir_de_moi_active } returns seSouvernirDeMoi

        mockkStatic(IsRememberMeAllowedUseCase.Companion.RootDetector::class)
        every { IsRememberMeAllowedUseCase.Companion.RootDetector.isDeviceRooted(any()) } returns isRooted

        mockkStatic(IsRememberMeAllowedUseCase.Companion.LockSecurityDetector::class)
        every { IsRememberMeAllowedUseCase.Companion.LockSecurityDetector.doesDeviceHaveSecuritySetup(any()) } returns hasSecuritySetup

        mockkObject(IsRememberMeAllowedUseCase.Companion.TestHelper)
        every { IsRememberMeAllowedUseCase.Companion.TestHelper.atLeastLollipop() } returns isAtLeastLollipop

        // When
        val result = IsRememberMeAllowedUseCase().execute()

        // Then
        assertThat(result).isEqualTo(expectedResult)
        clearAllMocks()
    }

    @After
    fun teardown() {
        clearAllMocks()
    }


    class PhoneSetupParamProvider {
        companion object {
            @JvmStatic
            fun provideRemeberMeAllowed(): Array<Any> {
                return arrayOf(arrayOf(true, false, true, true, true))
            }

            @JvmStatic
            fun provideRemeberMeNotAllowed(): Array<Any> {
                return arrayOf(
                    arrayOf(true, true, true, true, false),
                    arrayOf(false, true, true, true, false),
                    arrayOf(true, true, false, true, false),
                    arrayOf(true, true, true, false, false),
                    arrayOf(false, false, true, true, false),
                    arrayOf(false, false, false, true, false),
                    arrayOf(false, false, false, false, false)
                )
            }
        }
    }
}