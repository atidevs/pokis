package com.atidevs.pro.pokis.views

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atidevs.pro.pokis.R
import com.atidevs.pro.pokis.adapters.PokisAdapter
import com.atidevs.pro.pokis.listing.ListingFragment
import com.atidevs.pro.pokis.models.Poki
import com.atidevs.pro.pokis.viewmodels.PokiViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var pokisRecyclerView: RecyclerView
    private lateinit var pokisAdapter: PagedListAdapter<Poki, PokisAdapter.PokiViewHolder>
    private lateinit var gridLayoutManager: GridLayoutManager

    private lateinit var errorImgView: ImageView
    private lateinit var errorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.fragment_container_view, ListingFragment())
            .commitAllowingStateLoss()

        /*errorImgView = findViewById(R.id.image_view_error)
        errorTextView = findViewById(R.id.text_view_error_msg)

        val pokiViewModel = ViewModelProviders.of(this)
            .get(PokiViewModel::class.java)

        gridLayoutManager = GridLayoutManager(
            this,
            GRID_SPAN_COUNT
        )

        pokisAdapter = PokisAdapter()

        pokiViewModel.pokiPagedList.observe(this, Observer {
            pokisAdapter.submitList(it)
        })

        pokisRecyclerView = findViewById<RecyclerView>(R.id.recycler_view_pokis).apply {
            layoutManager = gridLayoutManager
            adapter = pokisAdapter
        }*/
    }

    companion object {
        private const val GRID_SPAN_COUNT: Int = 3
    }
}