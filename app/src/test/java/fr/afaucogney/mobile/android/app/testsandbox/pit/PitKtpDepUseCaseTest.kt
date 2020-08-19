package fr.afaucogney.mobile.android.app.testsandbox.pit

import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module
import toothpick.testing.ToothPickRule

class PitKtpDepUseCaseTest {

    lateinit var uut: PitKtpDepUseCase

    @get:Rule
    var toothPickRule = ToothPickRule(this, "Foo")

    @Before
    fun beforeEachTest() {
        toothPickRule.inject(this)

        toothPickRule.scope.installModules(module {
            bind<IPitInterface>().toInstance(PitProvider())
        })
        uut = toothPickRule.getInstance(PitKtpDepUseCase::class.java)
    }

    @Test
    fun test() {
        Assertions.assertThat(uut.execute(1)).isEqualTo(5)
    }
}
