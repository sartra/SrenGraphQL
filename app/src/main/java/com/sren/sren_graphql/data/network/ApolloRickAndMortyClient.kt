package com.sren.sren_graphql.data.network

import com.apollographql.apollo3.ApolloClient
import com.sren.sren_graphql.data.mapper.toCharacter
import com.sren.sren_graphql.data.mapper.toCharacterList
import com.sren.sren_graphql.domain.model.Character
import com.sren.sren_graphql.domain.model.SimpleCharacter
import com.sren.sren_graphql.domain.network.RickAndMortyClient
import com.sren_graphql.CharacterQuery
import com.sren_graphql.CharactersQuery

class ApolloRickAndMortyClient(
    private val apolloClient: ApolloClient
) : RickAndMortyClient {
    override suspend fun getCharacterList(): List<SimpleCharacter> =
        apolloClient
            .query(CharactersQuery())
            .execute()
            .data
            ?.characters
            ?.toCharacterList()
            .orEmpty()

    override suspend fun getCharacterById(id: String): Character? =
        apolloClient
            .query(CharacterQuery(id))
            .execute()
            .data
            ?.character
            ?.toCharacter()

}