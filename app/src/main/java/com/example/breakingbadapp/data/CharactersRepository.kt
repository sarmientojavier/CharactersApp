package com.example.breakingbadapp.data

import com.example.breakingbadapp.data.dto.CharacterDTO
import com.example.breakingbadapp.data.network.CharactersService
import javax.inject.Inject

/**
 * Created by Javier Sarmiento
 */

class CharactersRepository @Inject constructor(
    private val service: CharactersService,
    private val charactersProvider: CharactersProvider
) {

    suspend fun getCharacters(): List<CharacterDTO> {
        val response = service.getCharacters()
        charactersProvider.characters = response
        return response
    }

}