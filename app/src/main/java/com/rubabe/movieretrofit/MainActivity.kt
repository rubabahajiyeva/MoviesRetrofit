package com.rubabe.movieretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rubabe.movieretrofit.adapter.CategoryAdapter
import com.rubabe.movieretrofit.api.CategoriesApi
import com.rubabe.movieretrofit.databinding.ActivityMainBinding
import com.rubabe.movieretrofit.model.CategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: CategoryAdapter
    lateinit var categoryApi: CategoriesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarKategori.title = "Categories"
        setSupportActionBar(binding.toolbarKategori)

        binding.kategoriRv.setHasFixedSize(true)
        binding.kategoriRv.layoutManager = LinearLayoutManager(this)

        categoryApi = Constants.getCategoriesApi()
        gettumKategoriler()
    }

    fun gettumKategoriler() {
        categoryApi.tumKategoriler().enqueue(object : Callback<CategoriesResponse> {
            override fun onResponse(call: Call<CategoriesResponse>, response: Response<CategoriesResponse>) {
                val list = response.body()?.kategoriler
                adapter = list?.let { CategoryAdapter(this@MainActivity, it) }!!
                binding.kategoriRv.adapter = adapter
            }

            override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


}