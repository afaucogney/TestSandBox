package fr.afaucogney.mobile.android.app.testsandbox.complexe

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ObjectComplexeUseCaseTest {


    @Test
    fun test1() {
        assertThat(ComplexObjectUseCase().execute()).isNotEqualTo(
            ComplexObjectUseCase.ComplexeOne(
                "hello",
                "sopra",
                listOf("hello", "nantes")
            )
        )
    }

    @Test
    fun test2() {
        assertThat(ComplexObjectUseCase().execute()).isNotEqualTo(
            ComplexObjectUseCase.ComplexeOne(
                "hello",
                "niji",
                listOf("hello", "rennes","ff")
            )
        )
    }

    @Test
    fun test4() {
        assertThat(ComplexObjectUseCase().execute()).isNotEqualTo(
            ComplexObjectUseCase.ComplexeOne(
                "hello",
                "niji",
                listOf("hello", "rennes")
            )
        )
    }

    @Test
    fun test3() {
        assertThat(ComplexObjectUseCase().execute()).isEqualToComparingFieldByField(
            ComplexObjectUseCase.ComplexeOne(
                "hello",
                "niji",
                listOf("hello", "rennes")
            )
        )
    }


}