package com.example.rxforcv.character.api

import com.example.rxforcv.character.datasource.api.domain.usecase.model.Info
import com.example.rxforcv.character.datasource.api.domain.usecase.model.Result

data class CharacterResponse(
    var info: Info = Info(),
    var results: List<Result> = listOf()
)

