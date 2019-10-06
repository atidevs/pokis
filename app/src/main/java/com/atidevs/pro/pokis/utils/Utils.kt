package com.atidevs.pro.pokis.utils

class Utils {
    companion object {
        const val IMAGE_EXTENSION: String = ".png"

        const val IMAGE_BASE_URL =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon"

        fun getPokemonIdFromUrl(url: String): String? {
            val regex = Regex("/\\d+")
            val matchResult = regex.find(url)
            return matchResult?.value
        }
    }
}