package com.example.retrofitsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroesViewModel : ViewModel() {

    private var listMutableLiveData: MutableLiveData<List<Hero>?>? = null

    val liveData: LiveData<List<Hero>?>
        get() {
            if (listMutableLiveData == null) {
                listMutableLiveData =  MutableLiveData()
                loadHero()
            }
            return listMutableLiveData as MutableLiveData<List<Hero>?>
        }

    private fun loadHero() {
        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(Api::class.java)
        val call = api.heros
        call?.enqueue(object : Callback<List<Hero>?> {
            override fun onResponse(call: Call<List<Hero>?>, response: Response<List<Hero>?>) {
                listMutableLiveData?.value = response.body()
            }

            override fun onFailure(call: Call<List<Hero>?>, t: Throwable) {}
        })
    }
}