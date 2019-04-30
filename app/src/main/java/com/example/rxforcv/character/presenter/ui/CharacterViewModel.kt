package com.example.rxforcv.character.presenter.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.rxforcv.character.api.CharacterResponse
import com.example.rxforcv.core.BaseViewModel
import com.example.rxforcv.core.Usecase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CharacterViewModel(private val characterUsecase: Usecase<Unit, CharacterResponse>) : BaseViewModel() {
    val compositeDisposable = CompositeDisposable()
    var response = MutableLiveData<CharacterResponse>()

    var _characterResponse = MutableLiveData<CharacterResponse>()
    val characterResponse: LiveData<CharacterResponse>
        get() = _characterResponse


    fun requestCharacterList() {
        characterUsecase.execute(Unit)
            .subscribeOn(Schedulers.io()) // work at bg treading
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading() }
            .doFinally { hideLoading() }
            .subscribeBy(
                onNext = {
                    response.value = it

                },
                onError = {},
                onComplete = {}
            )
            .addTo(compositeDisposable)
    }

    private fun hideLoading() {

    }

    private fun showLoading() {

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}