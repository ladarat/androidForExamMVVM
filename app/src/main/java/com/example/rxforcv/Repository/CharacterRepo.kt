package com.example.rxforcv.Repository

import com.example.rxforcv.api.CharacterResponse
import com.example.rxforcv.api.CharacterAPI
import com.example.rxforcv.network.OkHttpClientFactory
import com.example.rxforcv.network.Retrofitfactory
import io.reactivex.Observable

class CharacterRepo: CharacterAdapter {
    override fun getCharacterAll(): Observable<CharacterResponse> {
        val api= Retrofitfactory.getInstance(OkHttpClientFactory.getInstance())
            .create(CharacterAPI::class.java)
        return api.getCharacter()
    }
}