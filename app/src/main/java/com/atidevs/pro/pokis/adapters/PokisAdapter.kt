package com.atidevs.pro.pokis.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.atidevs.pro.pokis.R
import com.atidevs.pro.pokis.models.Poki

class PokisAdapter(private var pokis: Array<Poki>) :
    RecyclerView.Adapter<PokisAdapter.PokisViewHolder>() {

    class PokisViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pokiTextView: TextView = view.findViewById(R.id.item_poki_name)
        val pokiImageView: ImageView = view.findViewById(R.id.item_poki_picture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokisViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.poki_item_recycler_view,
                parent,
                false
            )
        return PokisViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PokisViewHolder, position: Int) {
        holder.pokiTextView.text = pokis[position].name
        holder.pokiImageView.setImageBitmap(pokis[position].image)
    }

    override fun getItemCount(): Int {
        return pokis.size
    }
}