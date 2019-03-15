package fr.afaucogney.mobile.android.app.testsandbox

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class ListUseCaseTest {

    @Test
    fun test_run1() {
        assertThat(ListUseCase().execute()).isEqualTo(listOf(1, 2, 3, 4, 6, 7))
    }

}