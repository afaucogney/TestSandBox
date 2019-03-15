package fr.afaucogney.mobile.android.app.testsandbox.complexe

import org.assertj.core.api.Assertions
import org.junit.Test

class ComplexObjectWithDepUseCaseTest {

    @Test
    fun execute1() {
        Assertions.assertThat(ComplexObjectWithDepUseCase().execute()).isEqualTo(
            ComplexObjectWithDepUseCase.ComplexeOne(
                "hello",
                "niji",
                listOf("hello", "rennes"),
                ComplexObjectWithDepUseCase.ComplexeTwo(
                    "hello",
                    "rennes",
                    mapOf("hello" to "vitre")
                )
            )
        )

    }

    @Test
    fun execute2() {
        Assertions.assertThat(ComplexObjectWithDepUseCase().execute()).isEqualToComparingFieldByField(
            ComplexObjectWithDepUseCase.ComplexeOne(
                "hello",
                "niji",
                listOf("hello", "rennes"),
                ComplexObjectWithDepUseCase.ComplexeTwo(
                    "hello",
                    "rennes",
                    mapOf("hello" to "vitre")
                )
            )
        )

    }

    @Test
    fun execute3() {
        Assertions.assertThat(ComplexObjectWithDepUseCase().execute()).isEqualToComparingFieldByFieldRecursively(
            ComplexObjectWithDepUseCase.ComplexeOne(
                "hello",
                "niji",
                listOf("hello", "rennes"),
                ComplexObjectWithDepUseCase.ComplexeTwo(
                    "hello",
                    "rennes",
                    mapOf("hello" to "vitre")
                )
            )
        )

    }
}