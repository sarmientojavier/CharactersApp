package com.example.breakingbadapp.domain.mappers

import com.example.breakingbadapp.data.dto.CharacterDTO
import com.example.breakingbadapp.domain.models.Character
import com.example.breakingbadapp.domain.models.CharactersModel

/**
 * Created by Javier Sarmiento
 */

fun List<CharacterDTO>.toCharactersModel(): CharactersModel {
    val characterListModel = this.map { characterDTO -> characterDTO.toCharacter() }
    return CharactersModel(characterListModel)
}

fun CharacterDTO.toCharacter(): Character{
    return Character(id, name, nick, img, status, category, birthday, appearence)
}

