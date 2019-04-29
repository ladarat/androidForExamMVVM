package com.example.rxforcv.character.presenter.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.rxforcv.character.api.CharacterResponse
import com.example.rxforcv.core.Usecase

class CharacterListViewModelFactory(
    private val characterUsecase: Usecase<Unit, CharacterResponse>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterViewModel::class.java)) {
            return CharacterViewModel(
                characterUsecase = characterUsecase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}