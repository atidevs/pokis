package com.atidevs.pro.pokis.utils

import android.webkit.URLUtil
import com.atidevs.pro.pokis.utils.Utils.Companion.KEY_INDEX
import com.atidevs.pro.pokis.utils.Utils.Companion.VALUE_INDEX

class Utils {
    companion object {
        const val KEY_INDEX = 0
        const val VALUE_INDEX = 1

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

fun String.getQueryParams(): Map<String, String> {
    val queryParams: HashMap<String, String> = hashMapOf()
    if (URLUtil.isValidUrl(this)) {
        val queryString = this.substringAfterLast("/?", "")
        if (queryString.isNotEmpty()) {
            queryString.split("&").forEach {
                queryParams[it.split("=")[KEY_INDEX]] = it.split("=")[VALUE_INDEX]
            }
        }
    }
    return queryParams
}