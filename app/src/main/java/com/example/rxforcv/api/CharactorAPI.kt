package com.example.rxforcv.api

import io.reactivex.Observable
import retrofit2.http.GET

interface CharactorAPI {

    @GET("/charater")
    fun getCharacter(): Observable<CharacterResponse>
}