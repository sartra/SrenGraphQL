package com.sren.sren_graphql.data.di

import com.apollographql.apollo3.ApolloClient
import com.sren.sren_graphql.data.network.ApolloRickAndMortyClient
import com.sren.sren_graphql.domain.network.RickAndMortyClient
import com.sren.sren_graphql.domain.use_case.CharacterUseCases
import com.sren.sren_graphql.domain.use_case.GetCharacterById
import com.sren.sren_graphql.domain.use_case.GetCharacterList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient =
        ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .build()


    @Provides
    @Singleton
    fun provideRickAndMortyClient(
        apolloClient: ApolloClient
    ): RickAndMortyClient =
        ApolloRickAndMortyClient(apolloClient)

    @Provides
    @Singleton
    fun provideCharacterUseCases(
        rickAndMortyClient: RickAndMortyClient
    ): CharacterUseCases =
        CharacterUseCases(
            getCharacterById = GetCharacterById(rickAndMortyClient),
            getCharacterList = GetCharacterList(rickAndMortyClient)
        )
}