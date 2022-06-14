package com.atidevs.pro.pokis.api

import com.atidevs.pro.pokis.common.data.Poki
import com.atidevs.pro.pokis.common.data.PokiEntity

fun NetworkPoki.asPoki() = Poki(name = name, url = url)
fun NetworkPoki.asEntity() = PokiEntity(name = name, url = url)