package com.example.retrofitsample

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @get:GET("marvel/")
    val heros: Call<List<Hero>>

    companion object {
        const val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    }
}