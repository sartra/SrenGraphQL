package com.sren.sren_graphql.domain.use_case

import com.sren.sren_graphql.domain.model.SimpleCharacter
import com.sren.sren_graphql.domain.network.RickAndMortyClient

class GetCharacterList(
    private val client: RickAndMortyClient
) {
    suspend fun execute(): List<SimpleCharacter> =
        client.getCharacterList()

}