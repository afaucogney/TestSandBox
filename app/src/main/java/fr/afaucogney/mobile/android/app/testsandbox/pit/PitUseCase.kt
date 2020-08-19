package fr.afaucogney.mobile.android.app.testsandbox.pit

class PitUseCase {
    fun execute(p: Int): Int {
        return if (p > 0)
            p + 1
        else
            p - 2
    }
}
