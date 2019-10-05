package com.atidevs.pro.pokis

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atidevs.pro.pokis.adapters.PokisAdapter
import com.atidevs.pro.pokis.models.Poki

class MainActivity : AppCompatActivity() {

    private lateinit var pokisRecyclerView: RecyclerView
    private lateinit var pokisAdapter: RecyclerView.Adapter<PokisAdapter.PokisViewHolder>
    private lateinit var gridLayoutManager: GridLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridLayoutManager = GridLayoutManager(this, GRID_SPAN_COUNT)
        pokisAdapter = PokisAdapter(getDummyData())

        pokisRecyclerView = findViewById<RecyclerView>(R.id.recycler_view_pokis).apply {
            layoutManager = gridLayoutManager
            adapter = pokisAdapter
        }
    }

    fun getDummyData(): Array<Poki> {
        return arrayOf(
            Poki(
                "BULBASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_1)
            ),
            Poki(
                "HELDASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_2)
            ),
            Poki(
                "IVYSAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_3)
            ),
            Poki(
                "BULBASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_1)
            ),
            Poki(
                "HELDASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_2)
            ),
            Poki(
                "IVYSAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_3)
            ),
            Poki(
                "BULBASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_1)
            ),
            Poki(
                "HELDASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_2)
            ),
            Poki(
                "IVYSAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_3)
            ),
            Poki(
                "BULBASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_1)
            ),
            Poki(
                "HELDASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_2)
            ),
            Poki(
                "IVYSAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_3)
            ),
            Poki(
                "BULBASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_1)
            ),
            Poki(
                "HELDASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_2)
            ),
            Poki(
                "IVYSAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_3)
            ),
            Poki(
                "BULBASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_1)
            ),
            Poki(
                "HELDASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_2)
            ),
            Poki(
                "IVYSAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_3)
            ),
            Poki(
                pokiImage =
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_1)
            ),
            Poki(
                "HELDASAUR",
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_2)
            ),
            Poki(
                pokiImage =
                BitmapFactory.decodeResource(resources, R.mipmap.poki_placeholder_3)
            )
        )
    }

    companion object {
        private const val GRID_SPAN_COUNT: Int = 3
    }
}
