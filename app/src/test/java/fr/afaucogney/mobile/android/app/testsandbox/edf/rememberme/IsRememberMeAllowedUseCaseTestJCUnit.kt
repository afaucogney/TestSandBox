package fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme

import android.test.mock.MockContext
import com.github.dakusui.jcunit8.factorspace.Parameter
import com.github.dakusui.jcunit8.runners.helpers.ParameterUtils
import com.github.dakusui.jcunit8.runners.junit4.JCUnit8
import com.github.dakusui.jcunit8.runners.junit4.annotations.From
import com.github.dakusui.jcunit8.runners.junit4.annotations.ParameterSource
import fr.afaucogney.mobile.android.app.testsandbox.application.TestStandboxApplication
import io.mockk.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(JCUnit8::class)
class IsRememberMeAllowedUseCaseTestJCUnit {

    /**
     * Link : https://github.com/dakusui/jcunit
     * Strategy : main cases :)
     * Expected result is almost the same implementation than in the use case :o(
     */

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    companion object {
        private const val SESOUVENIRDEMOI = "seSouvernirDeMoi"
        private const val ISROOTED = "isRooted"
        private const val HASSECURITYSETUP = "hasSecuritySetup"
        private const val ISATLEASTLOLLIPO = "isAtLeastLollipop"
    }

    @ParameterSource
    fun seSouvernirDeMoi(): Parameter.Factory<Boolean> {
        return ParameterUtils.simple(false, true)
    }

    @ParameterSource
    fun isRooted(): Parameter.Factory<Boolean> {
        return ParameterUtils.simple(false, true)
    }

    @ParameterSource
    fun hasSecuritySetup(): Parameter.Factory<Boolean> {
        return ParameterUtils.simple(false, true)
    }

    @ParameterSource
    fun isAtLeastLollipop(): Parameter.Factory<Boolean> {
        return ParameterUtils.simple(false, true)
    }

    @Test
    fun test1(
        @From(SESOUVENIRDEMOI) seSouvernirDeMoi: Boolean,
        @From(ISROOTED) isRooted: Boolean,
        @From(HASSECURITYSETUP) hasSecuritySetup: Boolean,
        @From(ISATLEASTLOLLIPO) isAtLeastLollipop: Boolean
    ) {

        System.out.println(" ")
        System.out.println("# Scenario")
        System.out.println("## Stimulation")
        System.out.println("$SESOUVENIRDEMOI : $seSouvernirDeMoi")
        System.out.println("$ISROOTED : $isRooted")
        System.out.println("$HASSECURITYSETUP : $hasSecuritySetup")
        System.out.println("$ISATLEASTLOLLIPO : $isAtLeastLollipop")

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
        System.out.println("## Measured result")
        System.out.println(" => $result")

        // Then
        val expectedResult =
            seSouvernirDeMoi
                    && hasSecuritySetup
                    && isAtLeastLollipop
                    && !isRooted
        System.out.println("## Expected result")
        System.out.println(" => $expectedResult")

        assertThat(result).isEqualTo(expectedResult)
        clearAllMocks()
    }

    @After
    fun teardown() {
        clearAllMocks()
    }
}