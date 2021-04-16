package com.example.androidbasic.belajarfragment.belajarrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbasic.R
import java.util.ArrayList

class SuperHeroAdapter(private val list: ArrayList<SuperHero>) : RecyclerView.Adapter<SuperHeroAdapter .SuperHeroViewHolder>(){

    inner class SuperHeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var tv_nama: TextView
        lateinit var tv_deskripsi: TextView


        fun bind(superHero: SuperHero){
            tv_nama = itemView.findViewById(R.id.tv_nama)
            tv_deskripsi = itemView.findViewById(R.id.tv_deskripsi)
            with(itemView){
                tv_nama.text = superHero.name
                tv_deskripsi.text = superHero.desc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return SuperHeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}