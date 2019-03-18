package fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme

import com.carrotsearch.randomizedtesting.RandomizedTest
import com.carrotsearch.randomizedtesting.annotations.Seed
import com.carrotsearch.randomizedtesting.annotations.Seeds
import org.junit.AfterClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Suite


@RunWith(Suite::class)
@Suite.SuiteClasses(
        IsRememberMeAllowedUseCaseTestRandomSuite.OrderRandomized::class,
        IsRememberMeAllowedUseCaseTestRandomSuite.OrderRandomizedButFixed::class,
        IsRememberMeAllowedUseCaseTestRandomSuite.OrderRegression::class
)
class IsRememberMeAllowedUseCaseTestRandomSuite {

    class OrderRandomized : RandomizedTest() {
        @Test
        fun method1() {
            println("method1, " + RandomizedTest.randomInt())
        }

        @Test
        fun method2() {
            println("method2, " + RandomizedTest.randomInt())
        }

        @Test
        fun method3() {
            println("method3, " + RandomizedTest.randomInt())
        }

        companion object {

            @AfterClass
            fun empty() {
                println("--")
            }
        }
    }


    @Seed("deadbeef")
    class OrderRandomizedButFixed : IsRememberMeAllowedUseCaseTestRandom()

    class OrderRegression : RandomizedTest() {
        @Seeds(Seed("deadbeef"), Seed())
        @Test
        fun regression() {
            println("regression, " + RandomizedTest.randomInt())
        }
    }

}