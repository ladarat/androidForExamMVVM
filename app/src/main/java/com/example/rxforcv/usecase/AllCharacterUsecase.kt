package com.example.rxforcv.usecase

import com.example.rxforcv.Repository.CharacterAdapter
import com.example.rxforcv.api.CharacterResponse
import io.reactivex.Observable

class AllCharacterUsecase(private val characterAdapter: CharacterAdapter) : Usecase<Unit, CharacterResponse>() {
    override fun createObservable(request: Unit): Observable<CharacterResponse> {
        return characterAdapter.getCharacterAll()
    }
}