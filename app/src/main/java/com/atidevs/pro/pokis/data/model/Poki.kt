package com.atidevs.pro.pokis.data.model

/**
 * Data representation of a Pokémon
 * @param name: of the pokémon
 * @param url: for retrieving more details about the pokémon
 */

data class Poki(
    val name: String = "",
    val url: String = ""
) {
    override fun equals(other: Any?): Boolean {
        return if (other != null && other is Poki) {
            this.hashCode() == other.hashCode()
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + url.hashCode()
        return result
    }
}