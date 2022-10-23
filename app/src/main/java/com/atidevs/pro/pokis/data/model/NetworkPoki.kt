package com.atidevs.pro.pokis.data.model

import kotlinx.serialization.Serializable

/**
 * Network representation of a Pokémon
 * @param name: of the pokémon
 * @param url: for retrieving more details about the pokémon
 */

@Serializable
data class NetworkPoki(
    val name: String,
    val url: String
)