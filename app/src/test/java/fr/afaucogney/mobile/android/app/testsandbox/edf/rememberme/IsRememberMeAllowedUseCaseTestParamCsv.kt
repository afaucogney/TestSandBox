package fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme

import android.test.mock.MockContext
import fr.afaucogney.mobile.android.app.testsandbox.application.TestStandboxApplication
import io.mockk.*
import junitparams.FileParameters
import junitparams.JUnitParamsRunner
import junitparams.mappers.IdentityMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.Reader
import java.util.*


@RunWith(JUnitParamsRunner::class)
class IsRememberMeAllowedUseCaseTestParamCsv {

    /**
     *
     * Link : https://github.com/Pragmatists/JUnitParams
     */


    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    @FileParameters(
        value = "src/test/res/testdata/IsRememberMeParam.csv",
        mapper = CustomMapper::class
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

    class CustomMapper : IdentityMapper() {
        override fun map(reader: Reader): Array<Any> {
            val map = super.map(reader)
            val result = LinkedList<Any>()
            for (lineObj in map) {
                val line = lineObj.toString()
                val v = ","
                val index0 = 0
                val index1 = line.indexOf(v, index0)
                val seSouvernirDeMoi = line.substring(index0, index1).toBoolean()
                val index2 = line.indexOf(v, index1)
                val isRooted = line.substring(index1, index2).toBoolean()
                val index3 = line.indexOf(v, index1)
                val hasSecuritySetup = line.substring(index2, index3).toBoolean()
                val index4 = line.indexOf(v, index1)
                val isAtLeastLollipop = line.substring(index3, index4).toBoolean()
                val index5 = line.indexOf(v, index1)
                val expectedResult = line.substring(index5, line.length).toBoolean()


                result.add(arrayOf(seSouvernirDeMoi, isRooted, hasSecuritySetup, isAtLeastLollipop, expectedResult))
            }
            return result.toTypedArray()
        }
    }
}
