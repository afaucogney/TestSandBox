package fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme

import android.test.mock.MockContext
import com.carrotsearch.randomizedtesting.RandomizedTest
import fr.afaucogney.mobile.android.app.testsandbox.application.TestStandboxApplication
import io.mockk.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

open class IsRememberMeAllowedUseCaseTestRandom : RandomizedTest() {


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

        // Stimulation
        val seSouvernirDeMoi = true
        val isRooted = true
        val hasSecuritySetup = true
        val isAtLeastLollipop = true

        // Then
        val expectedResult = false
        runTest(seSouvernirDeMoi, isRooted, hasSecuritySetup, isAtLeastLollipop, expectedResult)
    }

    @Test
    open fun test2() {

        // Stimulation
        val seSouvernirDeMoi = getRandom().nextBoolean()
        val isRooted = true
        val hasSecuritySetup = getRandom().nextBoolean()
        val isAtLeastLollipop = getRandom().nextBoolean()

        // Then
        val expectedResult = false
        runTest(seSouvernirDeMoi, isRooted, hasSecuritySetup, isAtLeastLollipop, expectedResult)
    }

    @After
    fun teardown() {
        clearAllMocks()
    }

    ///////////////////////////////////////////////////////////////////////////
    // HELPERS
    ///////////////////////////////////////////////////////////////////////////

    companion object {
        private const val SESOUVENIRDEMOI = "seSouvernirDeMoi"
        private const val ISROOTED = "isRooted"
        private const val HASSECURITYSETUP = "hasSecuritySetup"
        private const val ISATLEASTLOLLIPO = "isAtLeastLollipop"
    }

    fun runTest(
        seSouvernirDeMoi: Boolean,
        isRooted: Boolean,
        hasSecuritySetup: Boolean,
        isAtLeastLollipop: Boolean,
        expectedResult: Boolean
    ) {

        // Setup
        System.out.println(" ")
        System.out.println("# Scenario")

        // Given
        System.out.println("## Stimulation")
        System.out.println("$SESOUVENIRDEMOI : $seSouvernirDeMoi")
        System.out.println("$ISROOTED : $isRooted")
        System.out.println("$HASSECURITYSETUP : $hasSecuritySetup")
        System.out.println("$ISATLEASTLOLLIPO : $isAtLeastLollipop")
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
        System.out.println("## Expected result")
        System.out.println(" => $expectedResult")
        assertThat(result).isEqualTo(expectedResult)

        // Teardown
        clearAllMocks()
    }

}