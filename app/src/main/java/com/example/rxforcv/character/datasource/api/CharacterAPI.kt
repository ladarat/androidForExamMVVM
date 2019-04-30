package com.example.rxforcv.character.api

import io.reactivex.Observable
import retrofit2.http.GET

interface CharacterAPI {

    @GET("character")
    fun getCharacter(): Observable<CharacterResponse>
}