package com.example.rxforcv.api

import io.reactivex.Observable
import retrofit2.http.GET

interface getProfileAPI {
    @GET("/me")
    fun getProfile(): Observable<ProfileModel>

}