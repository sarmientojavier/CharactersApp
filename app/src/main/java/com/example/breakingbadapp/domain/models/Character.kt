package com.example.breakingbadapp.domain.models

import com.google.gson.annotations.SerializedName

data class Character(
    val id: Int?,
    val name: String?,
    val nick: String?,
    val img: String?,
    val status: String?,
    val category: String?,
    val birthday: String?,
    val appearence: List<Int>?
)
