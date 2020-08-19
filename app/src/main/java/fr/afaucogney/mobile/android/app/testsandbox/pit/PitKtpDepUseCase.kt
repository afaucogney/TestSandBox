package fr.afaucogney.mobile.android.app.testsandbox.pit

import fr.afaucogney.mobile.android.app.testsandbox.pit.IPitInterface
import javax.inject.Inject

class PitKtpDepUseCase @Inject constructor() {

    @Inject
    lateinit var dep : IPitInterface

    fun execute(p: Int): Int {
        return if (p > 0)
            p + dep.provideNumber()
        else
            p - dep.provideNumber()
    }
}
