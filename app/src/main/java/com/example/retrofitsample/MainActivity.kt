package com.example.retrofitsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adapter: HeroesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val heroesViewModel = ViewModelProvider.NewInstanceFactory().create(
            HeroesViewModel::class.java
        )
        heroesViewModel.liveData.observe(this, Observer<List<Hero?>?> { heroes: List<Hero?>? ->
            adapter = HeroesAdapter(this, heroes as List<Hero>)
            recyclerView?.adapter = adapter
        })
    }
}