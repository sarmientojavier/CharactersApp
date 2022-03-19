package com.example.breakingbadapp.presentation.lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.breakingbadapp.databinding.FragmentCharacterListBinding
import com.example.breakingbadapp.presentation.adapters.CharacterAdapter
import com.example.breakingbadapp.presentation.viewmodels.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Javier Sarmiento
 */
@AndroidEntryPoint
class CharactersListFragment: Fragment(){

    private var _binding: FragmentCharacterListBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!
    private val charactersViewModel : CharactersViewModel by activityViewModels()
    private var mAdapter: CharacterAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shimmerLayout.startShimmer()
        charactersViewModel.characterList.observe(viewLifecycleOwner, { charactersModel ->
            mAdapter = context?.let { CharacterAdapter(it, charactersModel.characters) }
            binding.rvCharacters.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context)
            }
            binding.shimmerLayout.stopShimmer()
            binding.shimmerLayout.visibility = View.GONE

        })
        charactersViewModel.getCharacterList()
    }
}