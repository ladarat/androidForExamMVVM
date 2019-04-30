package com.example.rxforcv.domain

import com.example.rxforcv.character.api.CharacterResponse
import com.example.rxforcv.character.datasource.api.Repository.CharacterAdapter
import com.example.rxforcv.character.datasource.api.Repository.CharacterRepo
import com.example.rxforcv.character.datasource.api.domain.usecase.AllCharacterUsecase
import com.example.rxforcv.character.datasource.api.domain.usecase.model.Result
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class AllCharacterUsecaseTest {

    private lateinit var allCharacterUsecase: AllCharacterUsecase

    @Mock
    lateinit var characterRepo: CharacterAdapter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        allCharacterUsecase = AllCharacterUsecase(characterRepo)
    }

    @Test
    fun executeAllCharacteSuccess() {
        var characterResponse = CharacterResponse().apply { results = listOf() }
        whenever(characterRepo.getCharacterAll()).thenReturn(Observable.just(characterResponse))

        val observable = allCharacterUsecase.execute(Unit).test()


        observable.assertValue(CharacterResponse())
        verify(characterRepo).getCharacterAll()

    }
}