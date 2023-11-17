package com.sren.sren_graphql.domain.use_case

import com.sren.sren_graphql.domain.network.RickAndMortyClient

class GetCharacterById(
    private val client: RickAndMortyClient
) {
    suspend fun execute(id: String) = client.getCharacterById(id)
}