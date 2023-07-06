package com.rubabe.movieretrofit.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.rubabe.movieretrofit.DetailActivity
import com.rubabe.movieretrofit.R
import com.rubabe.movieretrofit.model.Movies
import com.squareup.picasso.Picasso

class MoviesAdapter(private val mContext: Context, private val filmlerListe:List<Movies>)
: RecyclerView.Adapter<MoviesAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: View) : RecyclerView.ViewHolder(tasarim){
        var film_card: CardView
        var textViewFilmAd: TextView
        var imageViewFilmResim: ImageView

        init {
            film_card = tasarim.findViewById(R.id.film_card)
            textViewFilmAd = tasarim.findViewById(R.id.textViewFilmAd)
            imageViewFilmResim = tasarim.findViewById(R.id.imageViewFilmResim)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.movie_card_design,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return filmlerListe.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListe[position]

        holder.textViewFilmAd.text = film.film_ad

        val url = "http://kasimadalan.pe.hu/filmler/resimler/${film.film_resim}"

        Picasso.get().load(url).into(holder.imageViewFilmResim)

        holder.film_card.setOnClickListener {

            val intent = Intent(mContext, DetailActivity::class.java)
            intent.putExtra("filmNesne",film)
            mContext.startActivity(intent)

        }
    }
}