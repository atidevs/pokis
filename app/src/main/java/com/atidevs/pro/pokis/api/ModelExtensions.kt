package com.atidevs.pro.pokis.api

import com.atidevs.pro.pokis.listing.Poki

fun NetworkPoki.asPoki() = Poki(name = name, url = url)