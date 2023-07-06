package com.rubabe.movieretrofit.api

import com.rubabe.movieretrofit.model.CategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface CategoriesApi {

    @GET("filmler/tum_kategoriler.php")
    fun tumKategoriler(): Call<CategoriesResponse>
}