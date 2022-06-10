package com.atidevs.pro.pokis.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.atidevs.pro.pokis.R
import com.atidevs.pro.pokis.listing.ListingFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view, ListingFragment())
                .commitAllowingStateLoss()
        }
    }
}