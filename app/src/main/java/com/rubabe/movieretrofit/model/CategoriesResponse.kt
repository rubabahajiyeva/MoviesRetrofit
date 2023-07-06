package com.rubabe.movieretrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CategoriesResponse(
    @SerializedName("kategoriler")
    @Expose
    var kategoriler: List<Categories>,
    @SerializedName("success:Int")
    @Expose
    var success: Int
) : Serializable