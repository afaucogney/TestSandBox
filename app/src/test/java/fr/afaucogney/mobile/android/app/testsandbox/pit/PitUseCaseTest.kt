package fr.afaucogney.mobile.android.app.testsandbox.pit

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PitUseCaseTest {

    @Test
    fun test() {
        assertThat(PitUseCase().execute(1)).isEqualTo(2)
    }
}
