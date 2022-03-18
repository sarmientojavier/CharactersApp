package com.example.breakingbadapp.data.network

import com.example.breakingbadapp.data.dto.CharacterDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Javier Sarmiento
 */
class CharactersService @Inject constructor(private val api:CharactersApi){

    suspend fun getCharacters(): List<CharacterDTO> {
        return withContext(Dispatchers.IO) {
            val response = api.getCharacters()
            response.body() ?: emptyList()
        }
    }

}