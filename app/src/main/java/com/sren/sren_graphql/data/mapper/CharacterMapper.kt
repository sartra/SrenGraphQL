package com.sren.sren_graphql.data.mapper

import com.sren.sren_graphql.domain.model.SimpleCharacter
import com.sren.sren_graphql.domain.model.Character
import com.sren_graphql.CharacterQuery
import com.sren_graphql.CharactersQuery

fun CharactersQuery.Characters.toCharacterList(): List<SimpleCharacter> =
    this.results
        ?.mapNotNull { result ->
            SimpleCharacter(
                id = result?.id.orEmpty(),
                name = result?.name.orEmpty(),
                image = result?.image.orEmpty(),
                species = result?.species.orEmpty()
            )
        }.orEmpty()

fun CharacterQuery.Character.toCharacter(): Character =
    Character(
        id = this.id.orEmpty(),
        name = this.name.orEmpty(),
        gender = this.gender.orEmpty(),
        image = this.image.orEmpty(),
        species = this.species.orEmpty()
    )
