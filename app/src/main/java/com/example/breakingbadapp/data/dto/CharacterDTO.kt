package com.example.breakingbadapp.data.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by Javier Sarmiento
 */

data class CharacterDTO(
    @SerializedName("char_id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("nickName") val nick: String,
    @SerializedName("img") val img: String,
    @SerializedName("status") val status: String,
    @SerializedName("category") val category: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("appearance") val appearence: List<Int>
)
