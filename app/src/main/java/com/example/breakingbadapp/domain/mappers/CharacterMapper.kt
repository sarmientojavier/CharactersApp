package com.example.breakingbadapp.domain

import com.example.breakingbadapp.data.dto.CharacterDTO
import com.example.breakingbadapp.domain.models.CharactersModel

/**
 * Created by Javier Sarmiento
 */

fun List<CharacterDTO>.toCharactersModel(): CharactersModel {

    return CharactersModel(this.groupBy { it.category })
}