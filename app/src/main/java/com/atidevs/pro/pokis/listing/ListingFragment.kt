package com.atidevs.pro.pokis.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.atidevs.pro.pokis.adapters.PokeAdapter
import com.atidevs.pro.pokis.databinding.FragmentListingBinding

class ListingFragment : Fragment() {

    private val listingViewModel: ListingViewModel by viewModels()

    private var _binding: FragmentListingBinding? = null
    private val binding get() = _binding!!

    private val gridLayoutManager by lazy { GridLayoutManager(context, GRID_SPAN_COUNT) }
    private val pokeAdapter by lazy { PokeAdapter() }

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

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val GRID_SPAN_COUNT: Int = 3
    }
}