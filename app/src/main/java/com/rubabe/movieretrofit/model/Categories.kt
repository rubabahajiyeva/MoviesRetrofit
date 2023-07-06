package com.rubabe.movieretrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Categories(
    @SerializedName("kategori_id")
    @Expose
    var kategori_id: Int,
    @SerializedName("kategori_ad")
    @Expose
    var kategori_ad: String): Serializable {
}