package com.example.breakingbadapp.domain.models

import android.content.Context
import android.os.Build
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.example.breakingbadapp.R
import kotlinx.parcelize.Parcelize
import java.text.ParseException
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

@Parcelize
data class Character(
    val id: Int?,
    val name: String?,
    val nick: String?,
    val img: String?,
    val status: String?,
    val category: String?,
    val birthday: String?,
    val appearence: List<Int>?
) : Parcelable {

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAgeText(context: Context?): String? {
        val ageText: String
        val formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy")
        ageText = try {
            val birthDate = LocalDate.parse(birthday, formatter)
            val today = LocalDate.now()
            val period: Period = Period.between(birthDate, today)
            context?.resources?.getString(
                R.string.character_age_text,
                period.years.toString(), period.months.toString(), period.days.toString()
            ).toString()
        } catch (e: DateTimeParseException) {
            e.printStackTrace()
            birthday ?: ""
        }

        return ageText
    }

    fun getSeasons(): String {
        var seasonsText = ""
        appearence?.forEach {
            val season: String = it.toString()
            seasonsText += season
            seasonsText += " "
        }
        return seasonsText
    }

}