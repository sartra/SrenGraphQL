package com.sren.sren_graphql.ui.screen.character_list

import com.sren.sren_graphql.domain.model.SimpleCharacter

data class CharacterListState(
    val isLoading: Boolean = false,
    val characterList: List<SimpleCharacter> = emptyList()
)