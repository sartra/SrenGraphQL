package com.sren.sren_graphql.domain.use_case

data class CharacterUseCases (
    val getCharacterById: GetCharacterById,
    val getCharacterList: GetCharacterList
)