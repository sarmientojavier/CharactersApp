package com.example.breakingbadapp.presentation.lifecycle

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.breakingbadapp.databinding.FragmentDetailCharacterBinding
import com.example.breakingbadapp.domain.models.Character


/**
 * Created by Javier Sarmiento
 */

private const val ARG_CHARACTER = "CHARACTER"


class CharacterDetailDialog : DialogFragment() {

    private var character: Character? = null
    private var _binding: FragmentDetailCharacterBinding? = null
    private val binding get() = _binding!!

    companion object {

        const val CHARACTER_DETAIL_TAG = "CHARACTER_DETAIL_TAG"

        @JvmStatic
        fun newInstance(character: Character?) =
            CharacterDetailDialog().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_CHARACTER, character)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        retainInstance = true

        arguments?.let {
            character = it.getParcelable(ARG_CHARACTER)
        }
        return dialog
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvCharacterName.text = character?.name
        binding.tvCharacterAge.text = character?.getAgeText(context)
        binding.tvCharacterSeasons.text = character?.getSeasons()
        binding.tvCharacterPhrases.text = character?.nick
        binding.ivCloseDialog.setOnClickListener {
            this.dismiss()
        }

    }

}