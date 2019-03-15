package fr.afaucogney.mobile.android.app.testsandbox

import io.reactivex.Completable
import io.reactivex.Observable

class AsyncTestsObservable {

    fun simpleCase(toggle: Boolean): Observable<Boolean> {
        return Observable.just(toggle)
    }

    fun simpleError(toggle: Boolean): Observable<Boolean> {
        return when (toggle) {
            true -> Observable.just(toggle)
            false -> Observable.error(RuntimeException())
        }
    }
}