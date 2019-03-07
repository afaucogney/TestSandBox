package fr.afaucogney.mobile.android.app.testsandbox.extFunction

import java.util.*

class StringFormatUseCase {

    fun execute(toggle: Boolean) : String {
        return if (toggle) {
            String.format(Locale.FRANCE, "%s", toggle)
        } else {
            String.format(Locale.FRANCE, "%s", toggle)
        }
    }
}