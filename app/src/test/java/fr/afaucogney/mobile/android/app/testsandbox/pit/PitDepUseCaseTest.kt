package fr.afaucogney.mobile.android.app.testsandbox.pit

import org.assertj.core.api.Assertions
import org.junit.Ignore
import org.junit.Test

@Ignore
class PitDepUseCaseTest {

    @Test
    fun test() {
        Assertions.assertThat(PitDepUseCase().execute(1)).isEqualTo(5)
    }
}
