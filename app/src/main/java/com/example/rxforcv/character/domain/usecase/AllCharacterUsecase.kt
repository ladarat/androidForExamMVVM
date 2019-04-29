package com.example.rxforcv.character.datasource.api.domain.usecase

import com.example.rxforcv.character.datasource.api.Repository.CharacterAdapter
import com.example.rxforcv.character.api.CharacterResponse
import com.example.rxforcv.character.datasource.api.Repository.CharacterRepo
import com.example.rxforcv.core.Usecase
import io.reactivex.Observable

class AllCharacterUsecase(private val characterAdapter: CharacterAdapter) : Usecase<Unit, CharacterResponse>() {
    override fun createObservable(request: Unit): Observable<CharacterResponse> {
        return characterAdapter.getCharacterAll()
    }
}