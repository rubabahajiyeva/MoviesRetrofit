package com.rubabe.movieretrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movies(
    @SerializedName("film_id")
    @Expose
    var film_id: Int,
    @SerializedName("film_ad")
    @Expose
    var film_ad: String,
    @SerializedName("film_yil")
    @Expose
    var film_yil: Int,
    @SerializedName("film_resim")
    @Expose
    var film_resim: String,
    @SerializedName("kategori")
    @Expose
    var kategori: Categories,
    @SerializedName("yonetmen")
    @Expose
    var yonetmen: MovieDirectors
) : Serializable
