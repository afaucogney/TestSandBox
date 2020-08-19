package fr.afaucogney.mobile.android.app.testsandbox.pit

import io.mockk.every
import io.mockk.mockkConstructor
import org.assertj.core.api.Assertions
import org.junit.Ignore
import org.junit.Test

import io.mockk.proxy.MockKAgentFactory

class PitMockkDepUseCaseTest {

    @Test
    fun test() {
        mockkConstructor(PitProvider::class)
        every { anyConstructed<PitProvider>().provideNumber() } returns 4
        Assertions.assertThat(PitDepUseCase().execute(1)).isEqualTo(5)
    }
}
