package com.example.breakingbadapp.data.network

import com.example.breakingbadapp.data.dto.CharacterDTO
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Javier Sarmiento
 */
private const val GET_CHARACTERS = "characters"


interface CharactersApi {

    @GET(GET_CHARACTERS)
    suspend fun getCharacters(): Response<List<CharacterDTO>>

}