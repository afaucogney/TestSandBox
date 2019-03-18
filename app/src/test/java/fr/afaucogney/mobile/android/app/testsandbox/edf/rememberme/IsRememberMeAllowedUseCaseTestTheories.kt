package fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme

import android.test.mock.MockContext
import fr.afaucogney.mobile.android.app.testsandbox.application.TestStandboxApplication
import io.mockk.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.FromDataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import java.util.*


@RunWith(Theories::class)
class IsRememberMeAllowedUseCaseTestTheories {

    /**
     * Link : http://farenda.com/junit/junit-theories-with-datapoints
     * Strategy : test all cases :)
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

        @DataPoints(SESOUVENIRDEMOI)
        fun seSouvernirDeMoiValues(): BooleanArray {
            val booleans = booleanArrayOf(false, true)
            System.out.println("Generated test data: " + Arrays.toString(booleans))
            return booleans
        }

        @DataPoints(ISROOTED)
        fun isRootedValues(): BooleanArray {
            val booleans = booleanArrayOf(false, true)
            System.out.println("Generated test data: " + Arrays.toString(booleans))
            return booleans
        }

        @DataPoints(HASSECURITYSETUP)
        fun hasSecuritySetupValues(): BooleanArray {
            val booleans = booleanArrayOf(false, true)
            System.out.println("Generated test data: " + Arrays.toString(booleans))
            return booleans
        }

        @DataPoints(ISATLEASTLOLLIPO)
        fun isAtLeastLollipopValues(): BooleanArray {
            val booleans = booleanArrayOf(false, true)
            System.out.println("Generated test data: " + Arrays.toString(booleans))
            return booleans
        }
    }


    @Theory
    fun test1(
        @FromDataPoints(SESOUVENIRDEMOI) seSouvernirDeMoi: Boolean,
        @FromDataPoints(ISROOTED) isRooted: Boolean,
        @FromDataPoints(HASSECURITYSETUP) hasSecuritySetup: Boolean,
        @FromDataPoints(ISATLEASTLOLLIPO) isAtLeastLollipop: Boolean
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