package com.example.rxforcv.character.api

import com.example.rxforcv.character.datasource.api.domain.usecase.model.ProfileModel
import io.reactivex.Observable
import retrofit2.http.GET

interface getProfileAPI {
    @GET("/me")
    fun getProfile(): Observable<ProfileModel>

}