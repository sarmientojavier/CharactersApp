package com.example.breakingbadapp.presentation.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.breakingbadapp.R
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class CharachersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, CharactersListFragment()).commit()
    }
}