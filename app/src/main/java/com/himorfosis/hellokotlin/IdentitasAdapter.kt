package com.himorfosis.hellokotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class IdentitasAdapter (val userList: ArrayList<IdentitasClassData>) : RecyclerView.Adapter<IdentitasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdentitasAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: IdentitasAdapter.ViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: IdentitasClassData) {
            val nama = itemView.findViewById(R.id.nama) as TextView
            val gambar  = itemView.findViewById(R.id.gambar) as ImageView

            nama.text = user.name

            Picasso.get()
                .load(user.image)
                .error(R.drawable.broken_image)
                .into(gambar)

        }
    }

}