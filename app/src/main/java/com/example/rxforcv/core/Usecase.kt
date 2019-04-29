package com.example.rxforcv.core

import io.reactivex.Observable


abstract class Usecase<REQUEST, RESPONSE> {
    internal abstract fun createObservable(request: REQUEST): Observable<RESPONSE>

    fun execute(request: REQUEST): Observable<RESPONSE> {
        return createObservable(request)
    }
}
