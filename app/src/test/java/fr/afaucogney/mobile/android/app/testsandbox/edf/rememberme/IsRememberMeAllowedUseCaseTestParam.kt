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
class IsRememberMeAllowedUseCaseTestParam {

    /**
     *
     * Link : https://github.com/Pragmatists/JUnitParams
     */


    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    @Parameters(
        "true, false, true, true, true",
        "true, true, true, true, false",
        "false, true, true, true, false",
        "true, true, false, true, false",
        "true, true, true, false, false",
        "false, false, true, true, false",
        "false, false, false, true, false",
        "false, false, false, false, false"
    )
    fun test1(
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
}
