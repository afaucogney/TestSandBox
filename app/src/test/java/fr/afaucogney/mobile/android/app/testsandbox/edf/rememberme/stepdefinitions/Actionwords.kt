package fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme.stepdefinitions

import android.test.mock.MockContext
import fr.afaucogney.mobile.android.app.testsandbox.application.TestStandboxApplication
import fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme.IsRememberMeAllowedUseCase
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.mockkStatic
import org.assertj.core.api.Assertions

class Actionwords {

    var result: Boolean? = null

    // Given
    fun theOptionRememberMeIsSetToSeSouvenirDeMoi(seSouvenirDeMoi: String) {
        mockkStatic(TestStandboxApplication::class)
        every { TestStandboxApplication.applicationContext() } returns MockContext()

        val cf = mockk<IsRememberMeAllowedUseCase.Companion.AppConfiguration>()
        mockkStatic(IsRememberMeAllowedUseCase.Companion.AppConfiguration::class)
        every { IsRememberMeAllowedUseCase.Companion.AppConfiguration.readConfiguration(any()) } returns cf
        every { cf.is_se_souvenir_de_moi_active } returns seSouvenirDeMoi.toBoolean()
    }

    fun thePhoneIsRootedIsRooted(isRooted: String) {
        mockkStatic(IsRememberMeAllowedUseCase.Companion.RootDetector::class)
        every { IsRememberMeAllowedUseCase.Companion.RootDetector.isDeviceRooted(any()) } returns isRooted.toBoolean()
    }

    fun thePhoneHasSecuritySetupHasSecuritySetup(hasSecuritySetup: String) {
        mockkStatic(IsRememberMeAllowedUseCase.Companion.LockSecurityDetector::class)
        every { IsRememberMeAllowedUseCase.Companion.LockSecurityDetector.doesDeviceHaveSecuritySetup(any()) } returns hasSecuritySetup.toBoolean()
    }

    fun theAndroidVersionIsAtLeastLollipopIsAtLeastLollipop(isAtLeastLollipop: String) {
        mockkObject(IsRememberMeAllowedUseCase.Companion.TestHelper)
        every { IsRememberMeAllowedUseCase.Companion.TestHelper.atLeastLollipop() } returns isAtLeastLollipop.toBoolean()
    }

    // When
    fun theIsRememberMeAllowedUseCaseIsExecuted() {
        result = IsRememberMeAllowedUseCase().execute()
    }

    // Then
    fun theIsRememberMeOptionAvailabilityIsIsRememberMeAllowed(isRememberMeAllowed: String) {
        Assertions.assertThat(result).isEqualTo(isRememberMeAllowed.toBoolean())
    }
}