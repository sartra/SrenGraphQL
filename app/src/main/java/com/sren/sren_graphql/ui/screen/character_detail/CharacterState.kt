package com.sren.sren_graphql.ui.screen.character_detail

import com.sren.sren_graphql.domain.model.Character
data class CharacterState (
    val isLoading: Boolean = false,
    val character: Character? = null
)

