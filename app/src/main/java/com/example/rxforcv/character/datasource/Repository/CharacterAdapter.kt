package com.example.rxforcv.character.datasource.api.Repository

import com.example.rxforcv.character.api.CharacterResponse
import io.reactivex.Observable

interface CharacterAdapter {
//    fun getCharacterByPageCall(pages: Int): Observable<CharacterResponse>
    fun getCharacterAll(): Observable<CharacterResponse>
//    fun getCharacterByName(name: String): Observable<CharacterResponse>
}