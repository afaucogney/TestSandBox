package fr.afaucogney.mobile.android.app.testsandbox.complexe

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ObjectUseCaseTest {


    @Test
    fun test1() {
        assertThat(ObjectUseCase().execute()).isNotEqualTo(ObjectUseCase.SimpleOne("hello", "sopra"))
    }

    @Test
    fun test2() {
        assertThat(ObjectUseCase().execute()).isNotEqualTo(ObjectUseCase.SimpleOne("hello", "niji"))
    }

    @Test
    fun test3() {
        assertThat(ObjectUseCase().execute()).isEqualToComparingFieldByField(ObjectUseCase.SimpleOne("hello", "niji"))
    }


}