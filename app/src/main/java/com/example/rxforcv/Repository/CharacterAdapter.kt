package com.example.rxforcv.Repository

import com.example.rxforcv.api.CharacterResponse
import io.reactivex.Observable

interface CharacterAdapter {
    fun getCharacterByPageCall(pages: Int): Observable<CharacterResponse>
    fun getCharacterAll(): Observable<CharacterResponse>
    fun getCharacterByName(name: String): Observable<CharacterResponse>
}