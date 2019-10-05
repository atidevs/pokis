package com.atidevs.pro.pokis.models

import android.graphics.Bitmap

class Poki(pokiName: String = "NAME 404!", pokiImage: Bitmap?) {

    public var name: String = pokiName
        get() {
            return field
        }
        set(value: String) {
            field = value
        }

    public var image = pokiImage
        get() {
            return field
        }
        set(value: Bitmap?) {
            field = value
        }

}