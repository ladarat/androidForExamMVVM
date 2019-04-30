package com.example.rxforcv.character.datasource.api.domain.usecase.model

data class Info(
    var count: Int = 0,
    val next: String ="",
    val pages: Int = 0,
    val prev: String = ""
)