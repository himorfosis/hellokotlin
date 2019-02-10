package com.himorfosis.hellokotlin

import android.content.ClipData
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_item.view.*

class UtamaAdapter(private val heroes: List<IdentitasClassData>,
                   private val listener: HeroListener) : RecyclerView.Adapter<HeroHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): HeroHolder {
        return HeroHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.row_item, viewGroup, false))
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.bindHero(heroes[position], listener)
    }
}

interface HeroListener {
    fun onHeroClick(hero: IdentitasClassData)
}

class HeroHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val nama = view.nama
    private val gambar = view.gambar

    fun bindHero(hero: IdentitasClassData, listener: HeroListener) {
        nama.text = hero.name
        Picasso.get()
            .load(hero.image)
            .error(R.drawable.broken_image)
            .into(gambar)

        itemView.setOnClickListener { listener.onHeroClick(hero) }
    }

}

//class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//    // Holds the TextView that will add each animal to
//    val nomoritem = view.nomor
//}