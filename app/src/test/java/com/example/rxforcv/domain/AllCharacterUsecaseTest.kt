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
import java.lang.Error

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
        whenever(characterRepo.getCharacterAll()).thenReturn(Observable.just(CharacterResponse()))

        val observable = allCharacterUsecase.execute(Unit).test()


        verify(characterRepo).getCharacterAll()
        observable.assertValue(CharacterResponse())

    }

    @Test
    fun executeAllCharacterFail(){
        whenever(characterRepo.getCharacterAll()).thenReturn(Observable.error(::Error))

        val observable = allCharacterUsecase.execute(Unit).test()

        verify(characterRepo).getCharacterAll()
        observable.assertError(Error::class.java)
    }
}