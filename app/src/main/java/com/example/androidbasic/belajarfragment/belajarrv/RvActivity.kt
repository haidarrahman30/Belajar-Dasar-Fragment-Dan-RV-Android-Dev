package com.example.androidbasic.belajarfragment.belajarrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbasic.R

class RvActivity : AppCompatActivity() {

    private val list = ArrayList<SuperHero>()
    lateinit var rv_hero: RecyclerView
    lateinit var tv_size: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)

        rv_hero = findViewById(R.id.rv_hero)

        rv_hero.setHasFixedSize(true)
        list.addAll(getListSuperHero())

        rv_hero.layoutManager = LinearLayoutManager(this)
        val superHeroAdapter = SuperHeroAdapter(list)

        rv_hero.adapter = superHeroAdapter

        tv_size = findViewById(R.id.tv_size)
        tv_size.setText(list.size.toString()+" Hero")


    }

    private fun getListSuperHero() : ArrayList<SuperHero>{
        val name = resources.getStringArray(R.array.data_name)
        val desc = resources.getStringArray(R.array.data_desc)

        val listSuperHero = ArrayList<SuperHero>()
        for(i in name.indices){
            val superhero = SuperHero(
                name[i],
                desc[i]
            )
            listSuperHero.add(superhero)
        }
        return listSuperHero
    }
}