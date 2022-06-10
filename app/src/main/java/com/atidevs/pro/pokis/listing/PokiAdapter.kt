package com.atidevs.pro.pokis.listing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.atidevs.pro.pokis.R
import com.atidevs.pro.pokis.models.Poki
import com.atidevs.pro.pokis.utils.Utils
import com.squareup.picasso.Picasso
import java.util.*

class PokiAdapter : PagingDataAdapter<Poki, PokiAdapter.PokiViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.poki_item_recycler_view, parent, false)
        return PokiViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokiViewHolder, position: Int) {
        val poki = getItem(position)
        poki?.let { holder.bind(it) }
    }

    class PokiViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val pokiImage: ImageView = view.findViewById(R.id.item_poki_picture)
        private val pokiName: TextView = view.findViewById(R.id.item_poki_name)
        fun bind(poki: Poki) {
            pokiName.text = poki.name?.uppercase(Locale.FRENCH)
            Picasso.get()
                .load(Utils.IMAGE_BASE_URL + Utils.getPokemonIdFromUrl(poki.pokiUrl!!) + Utils.IMAGE_EXTENSION)
                .resize(96, 96)
                .centerInside()
                .placeholder(R.drawable.ic_loading)
                .into(pokiImage)
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Poki>() {
            override fun areItemsTheSame(oldItem: Poki, newItem: Poki): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Poki, newItem: Poki): Boolean =
                newItem == oldItem
        }
    }
}