package com.example.rxforcv.character.presenter.ui

import android.arch.lifecycle.ViewModel
import com.example.rxforcv.character.datasource.api.domain.usecase.AllCharacterUsecase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class CharacterViewModel(private val characterUsecase: AllCharacterUsecase) : ViewModel() {
    val compositeDisposable = CompositeDisposable()

    fun requestCharacterList() {
        characterUsecase.execute(Unit)
            .subscribeOn(Schedulers.io()) // work at bg treading
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading() }
            .doFinally { hideLoading() }
            .subscribeBy(
                onNext = {},
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