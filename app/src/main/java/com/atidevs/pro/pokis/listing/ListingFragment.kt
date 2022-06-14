package com.atidevs.pro.pokis.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.atidevs.pro.pokis.common.PokiVIewModelFactory
import com.atidevs.pro.pokis.databinding.FragmentListingBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListingFragment : Fragment() {

    private val listingViewModel by viewModels<ListingViewModel> {
        PokiVIewModelFactory(requireActivity().application)
    }

    private var _binding: FragmentListingBinding? = null
    private val binding get() = _binding!!

    private val gridLayoutManager by lazy { GridLayoutManager(context, GRID_SPAN_COUNT) }
    private val pokeAdapter by lazy { PokiAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewPokis.apply {
            layoutManager = gridLayoutManager
            adapter = pokeAdapter
        }
        lifecycleScope.launch {
            listingViewModel.pokiFlow.collect {
                pokeAdapter.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val GRID_SPAN_COUNT: Int = 3
    }
}