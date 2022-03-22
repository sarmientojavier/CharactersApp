package com.example.breakingbadapp.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbadapp.domain.models.Character
import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView

import com.bumptech.glide.request.RequestOptions

import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.breakingbadapp.R


/**
 * Created by Javier Sarmiento
 */
class CharacterAdapter(private val context: Context, private var characterList: List<Character>, private val cellClickListener: CellClickListener,) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_character, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindInformation(characterList[position], context)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(characterList[position])
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(characterUpdateList: List<Character>) {
        characterList = characterUpdateList
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvName: TextView = itemView.findViewById(R.id.tv_character_name)
        private val tvNick: TextView = itemView.findViewById(R.id.tv_character_nick)
        private val ivCharacter: ImageView = itemView.findViewById(R.id.iv_character)

        fun bindInformation(character: Character, context: Context) {
            tvName.text = character.name
            tvNick.text = character.nick
            Glide.with(context)
                .load(character.img)
                .apply(
                    RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_foreground)
                )
                .into(ivCharacter)
        }
    }
}

interface CellClickListener{
    fun onCellClickListener(character: Character)

}