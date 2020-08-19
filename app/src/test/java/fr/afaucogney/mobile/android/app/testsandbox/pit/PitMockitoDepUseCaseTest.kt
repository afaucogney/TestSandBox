package fr.afaucogney.mobile.android.app.testsandbox.pit

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.mockk.every
import io.mockk.mockkConstructor
import org.assertj.core.api.Assertions
import org.junit.Ignore
import org.junit.Test

@Ignore
class PitMockitoDepUseCaseTest {

    @Test
    fun test() {
        mock<PitProvider> {
            on {
                provideNumber()
            } doReturn (4)
        }
        Assertions.assertThat(PitDepUseCase().execute(1)).isEqualTo(5)
    }
}
