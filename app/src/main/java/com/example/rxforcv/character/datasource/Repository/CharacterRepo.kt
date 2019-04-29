package com.example.rxforcv.character.datasource.api.Repository

import com.example.rxforcv.character.api.CharacterResponse
import com.example.rxforcv.character.api.CharacterAPI
import com.example.rxforcv.core.network.OkHttpClientFactory
import com.example.rxforcv.core.network.Retrofitfactory
import io.reactivex.Observable

class CharacterRepo: CharacterAdapter {
    override fun getCharacterAll(): Observable<CharacterResponse> {
        val api= Retrofitfactory.getInstance(OkHttpClientFactory.getInstance())
            .create(CharacterAPI::class.java)
        return api.getCharacter()
    }
}