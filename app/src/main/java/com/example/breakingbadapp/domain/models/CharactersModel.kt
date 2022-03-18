package com.example.breakingbadapp.domain.models

import com.example.breakingbadapp.data.dto.CharacterDTO

data class CharactersModel (val characters : Map<String, List<CharacterDTO>>)
