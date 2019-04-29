package com.example.rxforcv

import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Retrofitfactory {
    companion object {
        fun getInstance(okHttpClient: OkHttpClient): Retrofit {
            val gsonBuilder = GsonBuilder().setLenient()
            val gson = gsonBuilder.create()
            val gsonConverterFactory = GsonConverterFactory.create(gson)
            val rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())

            return retrofit2.Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(okHttpClient)
                .build()

        }
    }
}