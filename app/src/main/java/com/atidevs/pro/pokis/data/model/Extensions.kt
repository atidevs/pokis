package com.atidevs.pro.pokis.api

import com.atidevs.pro.pokis.data.model.NetworkPoki
import com.atidevs.pro.pokis.data.model.Poki
import com.atidevs.pro.pokis.data.source.local.PokiEntity

fun NetworkPoki.asPoki() = Poki(name = name, url = url)

fun PokiEntity.asPoki() = Poki(name = name, url = url)

fun NetworkPoki.asEntity() = PokiEntity(name = name, url = url)

fun Poki.asEntity() = PokiEntity(name = name, url = url)