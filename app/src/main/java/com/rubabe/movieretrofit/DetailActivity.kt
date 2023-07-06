package com.rubabe.movieretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rubabe.movieretrofit.databinding.ActivityDetailBinding
import com.rubabe.movieretrofit.model.Movies
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val film = intent.getSerializableExtra("filmNesne") as Movies

        binding.textViewFilmAd.text = film.film_ad
        binding.textViewFilmYil.text = (film.film_yil).toString()
        binding.textViewYonetmen.text = film.yonetmen.yonetmen_ad

        val url = "http://kasimadalan.pe.hu/filmler/resimler/${film.film_resim}"

        Picasso.get().load(url).into(binding.imageViewResim)

    }
}