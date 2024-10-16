package com.atidevs.pro.pokis.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

/**
 * Network representation of a paginated pokemon list response
 * @param count: of all available pokémons
 * @param previous: url of the previous page
 * @param next: url of the next page
 * @param results: list of a single page of pokémons
 */

@Serializable
data class NetworkPagedResponse(
    val count: Int,
    @SerializedName("previous")
    val previousPage: String,
    @SerializedName("next")
    val nextPage: String,
    val results: List<NetworkPoki>
)