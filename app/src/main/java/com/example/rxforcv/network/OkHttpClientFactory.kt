package com.example.rxforcv.network

import com.example.rxforcv.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class OkHttpClientFactory {

    companion object {
        var TIME_OUT = 20L
        fun getInstance(): OkHttpClient {
            var okHttpClientBuilder = OkHttpClient.Builder()

            if (BuildConfig.DEBUG) {
                val interceptor = HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
                okHttpClientBuilder = okHttpClientBuilder.addInterceptor(interceptor)
            }

            return okHttpClientBuilder
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build()
        }
    }
}