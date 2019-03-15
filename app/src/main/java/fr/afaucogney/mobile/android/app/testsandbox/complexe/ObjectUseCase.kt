package fr.afaucogney.mobile.android.app.testsandbox.complexe

class ObjectUseCase {

    data class SimpleOne(val first: String, val second: String)

    fun execute(): SimpleOne {
        return SimpleOne("hello", "niji")
    }
}