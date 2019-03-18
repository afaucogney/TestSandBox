package fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme

import com.carrotsearch.randomizedtesting.RandomizedTest
import com.carrotsearch.randomizedtesting.annotations.Repeat
import com.carrotsearch.randomizedtesting.annotations.Seed
import com.carrotsearch.randomizedtesting.annotations.Seeds
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(
        IsRememberMeAllowedUseCaseTest::class,
        IsRememberMeAllowedUseCaseTestExtanded::class,
        IsRememberMeAllowedUseCaseTestParam::class,
        IsRememberMeAllowedUseCaseTestTheories::class,
        IsRememberMeAllowedUseCaseTestJCUnit::class,
        IsRememberMeAllowedUseCaseTestSuite.FullRandomness::class,
        IsRememberMeAllowedUseCaseTestSuite.RepeatIsRememberMeAllowedUseCaseTestRandom::class
)
class IsRememberMeAllowedUseCaseTestSuite {

    class FullRandomness : IsRememberMeAllowedUseCaseTestRandom() {

        @Seeds(
                Seed("1"),
                Seed("2"),
                Seed("3"),
                Seed("4"),
                Seed("5"),
                Seed("6"),
                Seed("7"),
                Seed()
        )
        @Test
        fun test3() {

            // Stimulation
            val seSouvernirDeMoi = RandomizedTest.getRandom().nextBoolean()
            val isRooted = true
            val hasSecuritySetup = RandomizedTest.getRandom().nextBoolean()
            val isAtLeastLollipop = RandomizedTest.getRandom().nextBoolean()

            // Then
            val expectedResult = false
            runTest(seSouvernirDeMoi, isRooted, hasSecuritySetup, isAtLeastLollipop, expectedResult)
        }
    }

    @Seed("deadbeef")
    class OrderRandomizedButFixed : IsRememberMeAllowedUseCaseTestRandom()

    class RepeatIsRememberMeAllowedUseCaseTestRandom : IsRememberMeAllowedUseCaseTestRandom() {

        @Repeat(iterations = 20, useConstantSeed = false)
        @Test
        fun test4() {

            // Stimulation
            val seSouvernirDeMoi = RandomizedTest.getRandom().nextBoolean()
            val isRooted = RandomizedTest.getRandom().nextBoolean()
            val hasSecuritySetup = RandomizedTest.getRandom().nextBoolean()
            val isAtLeastLollipop = RandomizedTest.getRandom().nextBoolean()

            // Then
            val expectedResult =
                    seSouvernirDeMoi
                            && hasSecuritySetup
                            && isAtLeastLollipop
                            && !isRooted
            runTest(seSouvernirDeMoi, isRooted, hasSecuritySetup, isAtLeastLollipop, expectedResult)
        }
    }
}