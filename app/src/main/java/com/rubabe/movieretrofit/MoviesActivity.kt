package com.rubabe.movieretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rubabe.movieretrofit.adapter.MoviesAdapter
import com.rubabe.movieretrofit.api.MoviesApi
import com.rubabe.movieretrofit.databinding.ActivityMoviesBinding
import com.rubabe.movieretrofit.model.Categories
import com.rubabe.movieretrofit.model.Movies
import com.rubabe.movieretrofit.model.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesActivity : AppCompatActivity() {
    lateinit var binding: ActivityMoviesBinding
    private lateinit var filmListe: ArrayList<Movies>
    private lateinit var adapter: MoviesAdapter
    private lateinit var moviesApi: MoviesApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kategori = intent.getSerializableExtra("kategoriNesne") as Categories

        binding.toolbarFilmler.title = "Filmler : ${kategori.kategori_ad}"
        setSupportActionBar(binding.toolbarFilmler)

        binding.filmlerRv.setHasFixedSize(true)
        binding.filmlerRv.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        moviesApi = Constants.getMoviesApi()

        getTumFilmlerByKategoriId(kategori.kategori_id)


    }


    fun getTumFilmlerByKategoriId(kategori_id: Int) {
        moviesApi.tumFilmlerByKategoriId(kategori_id).enqueue(object : Callback<MoviesResponse> {

            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {

                val liste = response.body()?.filmler

                adapter = liste?.let { MoviesAdapter(this@MoviesActivity, it) }!!

                binding.filmlerRv.adapter = adapter
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {

            }

        })
    }
}
