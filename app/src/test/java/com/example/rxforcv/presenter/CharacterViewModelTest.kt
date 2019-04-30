package com.example.rxforcv.presenter

import com.example.rxforcv.LiveDataTestUtil
import com.example.rxforcv.base.BaseTest
import com.example.rxforcv.character.api.CharacterResponse
import com.example.rxforcv.character.presenter.ui.CharacterViewModel
import com.example.rxforcv.core.Usecase
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.hamcrest.core.IsEqual
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CharacterViewModelTest : BaseTest() {

    @Mock
    lateinit var allCharacterUsecase: Usecase<Unit, CharacterResponse>

    @Test
    fun requestAllCharacterList_ItShouldBeReturnCharacterList() {
        MockitoAnnotations.initMocks(this)
        whenever(allCharacterUsecase.execute(any())).thenReturn(Observable.just(CharacterResponse()))


        val characterViewModel = CharacterViewModel(allCharacterUsecase)
        characterViewModel.requestCharacterList()

        assertThat(characterViewModel.response.value, Is(IsEqual.equalTo(CharacterResponse())))

    }

    @Test
    fun requestAllCharacter_Error() {
        MockitoAnnotations.initMocks(this)
        whenever(allCharacterUsecase.execute(any())).thenReturn(Observable.error(::Error))


        val characterViewModel = CharacterViewModel(allCharacterUsecase)
        characterViewModel.requestCharacterList()

        val eventError = LiveDataTestUtil.getValue(characterViewModel.errorEvent)?.getContentIfNotHandled()
        assertNotNull(eventError)

    }
}