package com.example.breakingbadapp.domain.usecases

import com.example.breakingbadapp.data.CharactersRepository
import com.example.breakingbadapp.domain.mappers.toCharactersModel
import javax.inject.Inject

/**
 * Created by Javier Sarmiento
 */
class CharactersUseCases @Inject constructor(private val repository: CharactersRepository) {

    suspend operator fun invoke() = repository.getCharacters().toCharactersModel()

}