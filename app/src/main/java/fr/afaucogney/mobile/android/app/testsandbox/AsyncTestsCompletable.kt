package fr.afaucogney.mobile.android.app.testsandbox

import io.reactivex.Completable

class AsyncTestsCompletable {

    fun simpleCase(toggle: Boolean): Completable {
        return when (toggle) {
            true -> Completable.complete()
            false -> Completable.never()
        }
    }

    fun simpleError(toggle: Boolean): Completable {
        return when (toggle) {
            true -> Completable.complete()
            false -> Completable.error(RuntimeException())
        }
    }
}