package com.atidevs.pro.pokis.api

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