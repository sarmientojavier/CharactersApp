package com.example.breakingbadapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbadapp.domain.models.CharactersModel
import com.example.breakingbadapp.domain.usecases.CharactersUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val charactersUseCases: CharactersUseCases) :
    ViewModel() {

    val characterList = MutableLiveData<CharactersModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun getCharacterList() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = charactersUseCases()

            if (!result.characters.isNullOrEmpty()) {
                characterList.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

}