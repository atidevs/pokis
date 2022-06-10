package com.atidevs.pro.pokis.models

import com.google.gson.annotations.SerializedName

class Poki {

    @field:SerializedName("name")
    var name: String? = null


    @field:SerializedName("url")
    var pokiUrl: String? = null

    override fun equals(other: Any?): Boolean {
        return if (other != null && other is Poki) {
            this.hashCode() == other.hashCode()
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (pokiUrl?.hashCode() ?: 0)
        return result
    }
}

class PokiResponse {
    @field:SerializedName("count")
    var count: Int? = 0

    @field:SerializedName("next")
    var nextDataset: String? = null

    @field:SerializedName("previous")
    var previousDataset: String? = null

    @field:SerializedName("results")
    var pokis: List<Poki>? = null
}