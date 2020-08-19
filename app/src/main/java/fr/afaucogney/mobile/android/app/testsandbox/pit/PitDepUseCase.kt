package fr.afaucogney.mobile.android.app.testsandbox.pit

class PitDepUseCase {

    val dep : IPitInterface = PitProvider()

    fun execute(p: Int): Int {
        return if (p > 0)
            p + dep.provideNumber()
        else
            p - dep.provideNumber()
    }
}
