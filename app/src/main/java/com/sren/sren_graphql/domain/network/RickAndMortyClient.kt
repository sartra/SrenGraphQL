package com.sren.sren_graphql.domain.network

import com.sren.sren_graphql.domain.model.Character
import com.sren.sren_graphql.domain.model.SimpleCharacter

interface RickAndMortyClient {

    suspend fun getCharacterList(): List<SimpleCharacter>

    suspend fun getCharacterById(id: String): Character?
}