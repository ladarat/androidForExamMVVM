package com.example.rxforcv.character.api

import io.reactivex.Observable
import retrofit2.http.GET

interface CharacterAPI {

    @GET("/charater")
    fun getCharacter(): Observable<CharacterResponse>
}