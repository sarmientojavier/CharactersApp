package com.example.breakingbadapp.data

import com.example.breakingbadapp.data.dto.CharacterDTO
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Javier Sarmiento
 */
@Singleton
class CharactersProvider @Inject constructor(){
        var characters:List<CharacterDTO> = emptyList()
}