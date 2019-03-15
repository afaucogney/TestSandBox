package fr.afaucogney.mobile.android.app.testsandbox.complexe

class ComplexObjectUseCase {

    data class ComplexeOne(val first: String, val second: String, val list: List<String>)

    fun execute(): ComplexeOne {
        return ComplexeOne("hello", "niji", listOf("hello", "rennes"))
    }
}