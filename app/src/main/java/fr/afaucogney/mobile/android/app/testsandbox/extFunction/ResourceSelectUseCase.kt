package fr.afaucogney.mobile.android.app.testsandbox.extFunction

import android.content.Context
import fr.afaucogney.mobile.android.app.testsandbox.R

class ResourceSelectUseCase(val context: Context) {

    fun execute(toggle: Boolean): String {
        return if (toggle) {
            context.getString(R.string.app_name)
        } else {
            context.getString(R.string.app_name_debug)
        }
    }
}