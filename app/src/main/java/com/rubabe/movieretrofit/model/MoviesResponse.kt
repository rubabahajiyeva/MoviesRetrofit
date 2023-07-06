package com.rubabe.movieretrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MoviesResponse(
    @SerializedName("filmler")
    @Expose
    var filmler: List<Movies>,
    @SerializedName("success:Int")
    @Expose
    var success: Int
) : Serializable
