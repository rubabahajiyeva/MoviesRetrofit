package com.rubabe.movieretrofit

import com.rubabe.movieretrofit.api.CategoriesApi
import com.rubabe.movieretrofit.api.MoviesApi
import com.rubabe.movieretrofit.network.RetrofitClient

class Constants {
    companion object {
        private const val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getCategoriesApi(): CategoriesApi {
            return RetrofitClient.getClient(BASE_URL).create(CategoriesApi::class.java)
        }

        fun getMoviesApi(): MoviesApi {
            return RetrofitClient.getClient(BASE_URL).create(MoviesApi::class.java)
        }

    }
}