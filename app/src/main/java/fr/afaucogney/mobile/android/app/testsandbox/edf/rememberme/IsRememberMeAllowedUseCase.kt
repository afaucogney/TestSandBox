package fr.afaucogney.mobile.android.app.testsandbox.edf.rememberme

import android.content.Context
import android.os.Build
import fr.afaucogney.mobile.android.app.testsandbox.application.TestStandboxApplication

/**
 * Retrieved from LoginFragment todo Improve
 */
class IsRememberMeAllowedUseCase {

    fun execute(): Boolean {
        // Functionality "Remember me" is allowed if:
        // - Device is not rooted
        // - Device is secured by PIN, password or pattern
        val vConfiguration = AppConfiguration.readConfiguration(
            TestStandboxApplication.applicationContext()
        )
        return !RootDetector.isDeviceRooted(TestStandboxApplication.applicationContext())
                && LockSecurityDetector.doesDeviceHaveSecuritySetup(TestStandboxApplication.applicationContext())
                && vConfiguration.is_se_souvenir_de_moi_active
                && TestHelper.atLeastLollipop()
    }

    companion object {
        object TestHelper {
            fun atLeastLollipop(): Boolean {
                return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
            }
        }

        object RootDetector {
            fun isDeviceRooted(appContext: Context): Boolean {
                return true
            }
        }

        object LockSecurityDetector {
            fun doesDeviceHaveSecuritySetup(appContext: Context): Boolean {
                return true
            }
        }

        class AppConfiguration {
            companion object {
                fun readConfiguration(appContext: Context): AppConfiguration {
                    return AppConfiguration()
                }
            }

            var is_se_souvenir_de_moi_active: Boolean = true
        }
    }
}

