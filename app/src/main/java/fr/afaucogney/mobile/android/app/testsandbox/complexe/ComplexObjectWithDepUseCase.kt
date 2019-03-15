package fr.afaucogney.mobile.android.app.testsandbox.complexe

class ComplexObjectWithDepUseCase {

    data class ComplexeOne(val first: String, val second: String, val list: List<String>, val dep: ComplexeTwo)
    data class ComplexeTwo(val first: String, val second: String, val list: Map<String, String>)

    fun execute(): ComplexeOne {
        return ComplexeOne(
            "hello", "niji",
            listOf("hello", "rennes"),
            ComplexeTwo("hello", "rennes", mapOf("hello" to "vitre"))
        )
    }
}