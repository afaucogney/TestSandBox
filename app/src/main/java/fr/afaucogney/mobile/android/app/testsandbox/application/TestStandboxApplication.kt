package fr.afaucogney.mobile.android.app.testsandbox.application

import android.app.Application
import android.content.Context

class TestStandboxApplication : Application() {

    companion object {
        var INSTANCE: TestStandboxApplication? = null

        @JvmStatic
        fun applicationContext(): Context {
            return INSTANCE!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    override fun onTerminate() {
        INSTANCE = null
        super.onTerminate()
    }
}